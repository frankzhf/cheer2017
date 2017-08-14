package net.frank.commons;

public interface CommonConstants {
	
	public int DEFAULT_STRING_BUFFER_LENGTH = 1024;
	public int SHORT_STRING_BUFFER_LENGTH = 256;
	public int DEFAULT_BYTE_BUFFER_LENGTH = 65536;
	public String POINT = ".";
	public String LEFT_BRACKET="(";
	public String RIGHT_BRACKET=")";
	public String UNDER_LINE = "_";
	public String EMPTY_STRING = "";
	public String STRING_ENTER = "\n";
	public String STRING_TAB = "\t";
	public String PATH_SYMBOL = "/";
	public char PATH_SYMBOL_CHAR = '/';
	public String ARRAY_SPLIT = "##";
	public String ARRAY_SPLIT_SEC = "#";
	public String LEFT_MED_BRACKET = "[";
	public String RIGHT_MED_BRACKET = "]";
	public String COMMA = ",";
	public String QUOT= "'";
	public String DQUOT= "\"";
	
	
	public String SPACE = " ";
	public String BOOLEAN_TRUE_STRING = "true";
	public String BOOLEAN_FALSE_STRING = "false";
	public String BOOLEAN_TRUE_STRING2 = "TRUE";
	public String BOOLEAN_FALSE_STRING2 = "FALSE";
	
	public String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
	public String DEFAULT_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
	
	public String DATA_FIELD_REFER_SYMBOL_BEG = "$";
	public String DATA_FIELD_REFER_SYMBOL_END = ".longString(id)";
	public String BO_SUPER_CLASS_NAME = "net.frank.framework.bo.BusinessObject";
	
	public Integer BIGDECIMAL_SCALE = 2;
	
	public String PROCESS_BLOB_SERVLET = "/attachment";
	
	public interface CLASS_NAME{
		public String CLASS_NAME_BOOLEAN = "java.lang.Boolean";
		public String CLASS_NAME_STRING = "java.lang.String";
		public String CLASS_NAME_INTEGER = "java.lang.Integer";
		public String CLASS_NAME_BYTE = "java.lang.Byte";
		public String CLASS_NAME_LONG = "java.lang.Long";
		public String CLASS_NAME_BIGDECIMAL = "java.math.BigDecimal";
		public String CLASS_NAME_DATE = "java.util.Date";
		public String CLASS_NAME_BLOB = "[B";
		public String CLASS_NAME_CLOB = "[C";
	}
	
	
	public interface TREE_CONFIG{
		public String DEFAULT_RESOUCE_ICON = "/global/images/xloadtree2b/folder.png";
		public String DEFAULT_RESOUCE_OPEN_ICON = "/global/images/xloadtree2b/openfolder.png";
		public String DEFAULT_NOT_RESOUCE_ICON = "/global/images/xloadtree2b/file.png";
	}
	
	public interface TREE_CONFIG_SM{
		public String DEFAULT_RESOUCE_ICON = "/resources/xtree2/img/folder.png";
		public String DEFAULT_RESOUCE_OPEN_ICON = "/resources/xtree2/img/openfolder.png";
		public String DEFAULT_NOT_RESOUCE_ICON = "/resources/xtree2/img/file.png";
	}
	
	public interface HTML_HEAD{
		public String PRAGMA = "pragma";
		public String NOCACHE = "no-cache";
		public String EXPIRES = "expires";
		public String ZERO = "0";
		public String RESPONSE_OUTPUT_UNCODE = "UTF-8";
	}
	
	public interface PAGE_MODE{
		public String EDIT = "edit";
		public String VIEW = "view";
	}
	
	public interface TYPE{
		public Long RESOURCE = 3L;
		public Long TYPE = 4L;
		public Long ACCOUNT = 5L;
		public Long GROUP = 6L;
		public Long ACCOUNT_2_GROUP = 7L;
		public Long PRIVILEGE = 8L;
		public Long ARTICLE =9L;
		public Long ATTACH = 10L;
		public Long IMAGE = 11L;
		public Long APPLICATION = 12L;
		public Long MENUITEM = 13L;
		public Long UNIT = 14L;
		public Long PERSON = 15L;
		public Long STAFF = 16L;
		public Long LIMIT = 17L;
		public Long COMMENT = 18L;
	}
	
	public interface PERMISSION {
		//base
		public Byte NONE = 0;
		public Byte READ = 4;
		public Byte WRITE = 2;
		public Byte RUN = 1;
		
		//ext
		public Byte ALL = 7;
		public Byte RW = 6;
		public Byte RX = 5;
		public Byte WX = 3;
	}
	
	public interface RESOURCE_ID{
		public Long ROOT = 1L;
	}
	
	public interface RESOURCE_ALIAS{
		public String ROOT = "/";
		public String TYPE_ROOT ="resType";
		public String HOME_ROOT ="home";
		public String GROUPS_ROOT ="group";
		public String OPT_ROOT ="opt";
		public String DICTIONARIES_ROOT ="dictionary" ;
		public String CONTEXT_TEMPLATES_ROOT ="contextTemplate";
		public String UNIT_ROOT ="unit";
		public String STAFF_ROOT ="staff";
		public String PERSON_ROOT ="person";
		public String VAR_ROOT="var";
		public String RECYCLE_ROOT ="recycle" ;
	}
	
	public interface PATH {
		public String ROOT_ACCOUNT = "/home/root";
		public String ADMIN_GROUP = "/group/Admin";
		public String GUEST_GROUP = "/group/Guest";
		public String SELF_GROUP = "/group/Self";
		public String HOME = "/home";	
	}
	
	public interface PERMISSION_GROUP{
		public interface PRIVATE{
			Byte CURRENT_ACCOUNT = 7;
			Byte CURRENT_GROUP = 0;
			Byte OTHERS = 0;
		}
		public interface PROTECTED{
			Byte CURRENT_ACCOUNT = 7;
			Byte CURRENT_GROUP = 4;
			Byte OTHERS = 4;
		}
		public interface PUBLIC{
			Byte CURRENT_ACCOUNT = 7;
			Byte CURRENT_GROUP = 7;
			Byte OTHERS = 7;
		}
	}
	
	public interface CONTEXT{
		public interface UNIT{
			//public String TASK = "task";
			//public String ARTICLE = "article";
			//public String REPOSITORY = "repository";
			public String CHILDREN = "children";
			public String GROUP = "group";
			public String GRANT = "grant";
		}
		public interface ACCOUNT{
			public String GROUP=".group";
			public String PRIVILEGE=".privilege";
			public String CONFIG=".config";
			//public String MY_DOCUMENT="myDocument";
			//public String RECYCLE_BIN="recycleBin";
		}
		public interface TASK{
			public String CHILDREN="children";
			public String TOKEN="token";
		}
		public interface TASK_TOKEN{
			public String ATTACH="attach";
			public String SCREENSHOT="screenshot";
			public String COMMENT="comment";
		}
	}
	
	public interface CMS_CODE {
		public Integer MESSAGE_OK = 0;
		public Integer MESSAGE_READ = -1;
		public Integer MESSAGE_WRITE = -2;
		public Integer MESSAGE_RUN = -3;
		public Integer MESSAGE_NOT_EXISTS = -4;
		public Integer MESSAGE_EXISTS = -5;
		public Integer MESSAGE_UNKNOW = -100;
	}
	
	public interface CMS_MESSAGE{
		public String MESSAGE_OK = "common.operate.success";
		public String MESSAGE_READ = "errors.cms.read";
		public String MESSAGE_WRITE = "errors.cms.write";
		public String MESSAGE_RUN = "errors.cms.run";
		public String MESSAGE_NOT_EXISTS = "errors.cms.object.not.exists";
		public String MESSAGE_EXISTS = "errors.cms.object.exists";
		public String MESSAGE_UNKNOW = "errors.cms.unknown";
	}
	
	public Long DEFAULT_BLOB_LENGTH_LIMIT = 16777215L;
}
