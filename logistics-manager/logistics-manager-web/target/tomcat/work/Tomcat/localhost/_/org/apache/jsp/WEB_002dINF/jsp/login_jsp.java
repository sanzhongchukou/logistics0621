/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-06-27 08:47:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>欢迎登录后台管理系统</title>\r\n");
      out.write("<link href=\"/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script language=\"JavaScript\" src=\"/js/jquery.js\"></script>\r\n");
      out.write("<script src=\"/js/cloud.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$('.loginbox').css({\r\n");
      out.write("\t\t\t'position' : 'absolute',\r\n");
      out.write("\t\t\t'left' : ($(window).width() - 692) / 2\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(window).resize(function() {\r\n");
      out.write("\t\t\t$('.loginbox').css({\r\n");
      out.write("\t\t\t\t'position' : 'absolute',\r\n");
      out.write("\t\t\t\t'left' : ($(window).width() - 692) / 2\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t})\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body\r\n");
      out.write("\tstyle=\"background-color: #1c77ac; background-image: url(images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"mainBody\">\r\n");
      out.write("\t\t<div id=\"cloud1\" class=\"cloud\"></div>\r\n");
      out.write("\t\t<div id=\"cloud2\" class=\"cloud\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"logintop\">\r\n");
      out.write("\t\t<span>欢迎登录后台管理界面平台</span>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li><a href=\"#\">回首页</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">帮助</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">关于</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"loginbody\">\r\n");
      out.write("\r\n");
      out.write("\t\t<span class=\"systemlogo\"></span>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"loginbox\">\r\n");
      out.write("\t\t<form action=\"/login.do\" method=\"post\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><input name=\"username\" type=\"text\" class=\"loginuser\" value=\"admin\"/></li>\r\n");
      out.write("\t\t\t\t<li><input name=\"password\" type=\"text\" class=\"loginpwd\" value=\"1\"/></li>\r\n");
      out.write("\t\t\t\t<li><input name=\"\" type=\"submit\" class=\"loginbtn\" value=\"登录\"/>\r\n");
      out.write("\t\t\t\t\t<label>\r\n");
      out.write("\t\t\t\t\t\t<input name=\"\" type=\"checkbox\" value=\"\" checked=\"checked\" />记住密码\r\n");
      out.write("\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t<label>\r\n");
      out.write("\t\t\t\t\t\t<font color=\"red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</font>\r\n");
      out.write("\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"loginbm\">\r\n");
      out.write("\t\t版权所有 2013 <a href=\"http://www.uimaker.com\">uimaker.com</a>\r\n");
      out.write("\t\t仅供学习交流，勿用于任何商业用途\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div style=\"display: none\">\r\n");
      out.write("\t\t<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'\r\n");
      out.write("\t\t\tlanguage='JavaScript' charset='gb2312'></script>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
