<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag import="net.frank.yangtes.prototype.util.AreaUtil" %>
<%@ tag import="net.frank.yangtes.prototype.Constant" %>


<%@ attribute name="id" type="java.lang.String" required="true" description="Area编号"%>
<%	
	String value = AreaUtil.formatName(id);
	if(!Constant.UNDEFINE_AREA.equals(value)){
		out.print(value);
	}else{
		out.print(Constant.HTML_SPACE);
	}
%>