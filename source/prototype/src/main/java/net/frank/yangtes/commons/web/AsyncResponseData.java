package net.frank.yangtes.commons.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

public final class AsyncResponseData {
	public static final int RESPONSE_STATUS_OK = 200; // 正常
	public static final int RESPONSE_STATUS_CLIENT_ERROR = 404; // 客户端错误
	public static final int RESPONSE_STATUS_REQUEST_DENIED = 401; // 访问受限
	public static final int RESPONSE_STATUS_INTERNAL_ERROR = 500; // 服务器内部错误
	public static final int RESPONSE_STATUS_REDIRECT = 302; // 需要用户登录,重定向请求

	private static final String ONE_MSG_KEY = "oneErrorMsg";
	private static final String ONE_DATA_KEY = "oneSimpleData";
	private static final String REDIRECT_URL_KEY = "redirectUrl";

	private AsyncResponseData() {
	}

	public static final ResultData get404Response(String errMsg) {
		return new ResultData(RESPONSE_STATUS_CLIENT_ERROR, errMsg);
	}

	public static final ResultData get404Response(Map<String, String> errMsgs) {
		return new ResultData(RESPONSE_STATUS_CLIENT_ERROR, errMsgs);
	}

	public static final ResultData get401Response(String errMsg) {
		return new ResultData(RESPONSE_STATUS_REQUEST_DENIED, errMsg);
	}

	public static final ResultData get500Response(String errMsg) {
		return new ResultData(RESPONSE_STATUS_INTERNAL_ERROR, errMsg);
	}

	public static final ResultData get302Response(String redirectUrl) {
		ResultData data = new ResultData(RESPONSE_STATUS_REDIRECT);
		data.appendData(REDIRECT_URL_KEY, redirectUrl);
		return data;
	}

	public static final ResultData get200Response() {
		return new ResultData(RESPONSE_STATUS_OK);
	}

	public static class ResultData {

		private ResultData(int code) {
			this.status = RESPONSE_STATUS_OK;
		}

		private ResultData(int code, String message) {
			this.status = code;
			this.messages = new HashMap<String, String>();
			this.messages.put(ONE_MSG_KEY, message);
		}

		private ResultData(int code, Map<String, String> messages) {
			this.status = code;
			this.messages = messages;
		}

		private int status;
		private Map<String, Object> data;
		private Map<String, String> messages;

		@JsonIgnore
		/**
		 * 判断当前消息是否为正常状态(200)
		 */
		public boolean isOk() {
			return this.status == RESPONSE_STATUS_OK ? true : false;
		}

		public int getStatus() {
			return status;
		}

		/**
		 * 返回 简单数据类型，通过putData(Object data)放入的数据
		 * 
		 * @return
		 */
		@JsonInclude(JsonInclude.Include.NON_EMPTY)
		public Object getData() {
			if (null == data) {
				return null;
			}
			if (data.containsKey(ONE_DATA_KEY)) {
				return data.get(ONE_DATA_KEY);
			} else {
				if (data.containsKey(REDIRECT_URL_KEY)) {
					Map<String, Object> map = new HashMap<>(data);
					map.remove(REDIRECT_URL_KEY);
					return map;
				}
				return data;
			}
		}

		/**
		 * 当需要重向时,返回重定向请求的 url 全路径(包含http部分)
		 * 
		 * @return
		 */
		@JsonInclude(JsonInclude.Include.NON_NULL)
		public Object getRedirect() {
			return null == this.data ? null : this.data.get(REDIRECT_URL_KEY);
		}

		/**
		 * 简单数据类型
		 * 
		 * @param data
		 */
		public void setData(Object data) {
			if (null == this.data) {
				this.data = new HashMap<String, Object>();
			}
			this.data.put(ONE_DATA_KEY, data);
		}

		public void setStatus(int status) {
			this.status = status;
		}

		/**
		 * 一般来讲用于执行完成无错误时，向客户端追加数据使用 使用setData后,再调用此方法追回的数据无效
		 * 
		 * @param key
		 * @param data
		 */
		public void appendData(String key, Object data) {
			if (null == this.data) {
				this.data = new HashMap<String, Object>();
			}
			this.data.put(key, data);
		}

		/**
		 * 非200状态 通知客户端错误信息的添加
		 * 
		 * @param key
		 * @param msg
		 */
		public void appendMessage(String key, String msg) {
			if (RESPONSE_STATUS_OK == this.status) {
				return;
			}
			if (null == this.messages) {
				this.messages = new HashMap<String, String>();
			}
			this.messages.put(key, msg);
		}

		public void setMessages(Map<String, String> messages) {
			this.messages = messages;
		}

		public ResultData as404() {
			return switchStatus(RESPONSE_STATUS_CLIENT_ERROR);
		}

		public ResultData as401() {
			return switchStatus(RESPONSE_STATUS_REQUEST_DENIED);
		}

		public ResultData as500() {
			return switchStatus(RESPONSE_STATUS_INTERNAL_ERROR);
		}

		public ResultData as302(String redirectUrl) {
			ResultData data = switchStatus(RESPONSE_STATUS_REDIRECT);
			if (RESPONSE_STATUS_REDIRECT == data.status) {
				data.appendData(REDIRECT_URL_KEY, redirectUrl);
			}
			return data;
		}

		public ResultData as404(String msg) {
			return switchStatus(RESPONSE_STATUS_CLIENT_ERROR).putOneMessage(msg);
		}

		public ResultData as401(String msg) {
			return switchStatus(RESPONSE_STATUS_REQUEST_DENIED).putOneMessage(msg);
		}

		public ResultData as500(String msg) {
			return switchStatus(RESPONSE_STATUS_INTERNAL_ERROR).putOneMessage(msg);
		}

		private ResultData switchStatus(int status) {
			if (status == this.status) {
				return this;
			}
			if (RESPONSE_STATUS_OK != this.status) {
				this.messages = new HashMap<String, String>();
				this.messages.put(ONE_MSG_KEY, "不能将" + this.status + "的消息转换为" + status);
				this.status = RESPONSE_STATUS_INTERNAL_ERROR;
				return this;
			}
			this.status = status;
			return this;
		}

		private ResultData putOneMessage(String msg) {
			if (null == this.messages) {
				this.messages = new HashMap<String, String>();
			}
			if (!this.messages.containsKey(ONE_MSG_KEY)) {
				this.messages.put(ONE_MSG_KEY, msg);
			}
			return this;
		}
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		public Object getMessage(){
            if(null == messages){
                return null;
            }
            if(messages.containsKey(ONE_MSG_KEY)){
                return messages.get(ONE_MSG_KEY);
            }
            return messages;
        }
		
	}
}
