/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2014-05-07 11:24:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class TipCards_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
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
      response.setContentType("text/html; charset=US-ASCII");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\" />\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("<title>Create an animated card layout that let you flip to see\n");
      out.write("\tthe content</title>\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\"\n");
      out.write("\thref=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" />\n");
      out.write("<!-- Edit Below -->\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"http://code.jquery.com/jquery-1.11.1.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\"></script>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\thref=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\thref=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\thref=\"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("\" />\n");
      out.write("<title>Insert title here</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t");
      out.write("\n");
      out.write("\t<div class=\"page_container\">\n");
      out.write("\t\t<ul class=\"tips\">\n");
      out.write("\t\t\t<li><a href=\"#tip1\">Tip 1: See What videos your friends are\n");
      out.write("\t\t\t\t\tposting and adjust friendships accordingly.</a>\n");
      out.write("\n");
      out.write("\t\t\t\t<div id=\"tip1\" class=\"tip\">\n");
      out.write("\t\t\t\t\t<h1>See What videos your friends are posting</h1>\n");
      out.write("\t\t\t\t\t<p>Whether you're browsing youtube.com or its mobile app, when\n");
      out.write("\t\t\t\t\t\tyou're signed in with your Google Account, you can see videos\n");
      out.write("\t\t\t\t\t\trecommended for you.</p>\n");
      out.write("\t\t\t\t</div></li>\n");
      out.write("\t\t\t<li><a href=\"#tip2\">Tip 1: See What videos your friends are\n");
      out.write("\t\t\t\t\tposting and adjust friendships accordingly.</a>\n");
      out.write("\n");
      out.write("\t\t\t\t<div id=\"tip2\" class=\"tip\">\n");
      out.write("\t\t\t\t\t<h1>See What videos your friends are posting</h1>\n");
      out.write("\t\t\t\t\t<p>Whether you're browsing youtube.com or its mobile app, when\n");
      out.write("\t\t\t\t\t\tyou're signed in with your Google Account, you can see videos\n");
      out.write("\t\t\t\t\t\trecommended for you.</p>\n");
      out.write("\t\t\t\t</div></li>\n");
      out.write("\t\t\t<li><a href=\"#tip3\">Tip 1: See What videos your friends are\n");
      out.write("\t\t\t\t\tposting and adjust friendships accordingly.</a>\n");
      out.write("\n");
      out.write("\t\t\t\t<div id=\"tip3\" class=\"tip\">\n");
      out.write("\t\t\t\t\t<h1>See What videos your friends are posting</h1>\n");
      out.write("\t\t\t\t\t<p>Whether you're browsing youtube.com or its mobile app, when\n");
      out.write("\t\t\t\t\t\tyou're signed in with your Google Account, you can see videos\n");
      out.write("\t\t\t\t\t\trecommended for you.</p>\n");
      out.write("\t\t\t\t</div></li>\n");
      out.write("\t\t\t<li><a href=\"#tip4\">Tip 1: See What videos your friends are\n");
      out.write("\t\t\t\t\tposting and adjust friendships accordingly.</a>\n");
      out.write("\n");
      out.write("\t\t\t\t<div id=\"tip4\" class=\"tip\">\n");
      out.write("\t\t\t\t\t<h1>See What videos your friends are posting</h1>\n");
      out.write("\t\t\t\t\t<p>Whether you're browsing youtube.com or its mobile app, when\n");
      out.write("\t\t\t\t\t\tyou're signed in with your Google Account, you can see videos\n");
      out.write("\t\t\t\t\t\trecommended for you.</p>\n");
      out.write("\t\t\t\t</div></li>\n");
      out.write("\t\t\t<li><a href=\"#tip5\">Tip 1: See What videos your friends are\n");
      out.write("\t\t\t\t\tposting and adjust friendships accordingly.</a>\n");
      out.write("\n");
      out.write("\t\t\t\t<div id=\"tip5\" class=\"tip\">\n");
      out.write("\t\t\t\t\t<h1>See What videos your friends are posting</h1>\n");
      out.write("\t\t\t\t\t<p>Whether you're browsing youtube.com or its mobile app, when\n");
      out.write("\t\t\t\t\t\tyou're signed in with your Google Account, you can see videos\n");
      out.write("\t\t\t\t\t\trecommended for you.</p>\n");
      out.write("\t\t\t\t</div></li>\n");
      out.write("\t\t\t<li><a href=\"#tip6\">Tip 1: See What videos your friends are\n");
      out.write("\t\t\t\t\tposting and adjust friendships accordingly.</a>\n");
      out.write("\n");
      out.write("\t\t\t\t<div id=\"tip6\" class=\"tip\">\n");
      out.write("\t\t\t\t\t<h1>See What videos your friends are posting</h1>\n");
      out.write("\t\t\t\t\t<p>Whether you're browsing youtube.com or its mobile app, when\n");
      out.write("\t\t\t\t\t\tyou're signed in with your Google Account, you can see videos\n");
      out.write("\t\t\t\t\t\trecommended for you.</p>\n");
      out.write("\t\t\t\t</div></li>\n");
      out.write("\t\t\t<li><a href=\"#tip7\">Tip 1: See What videos your friends are\n");
      out.write("\t\t\t\t\tposting and adjust friendships accordingly.</a>\n");
      out.write("\n");
      out.write("\t\t\t\t<div id=\"tip7\" class=\"tip\">\n");
      out.write("\t\t\t\t\t<h1>See What videos your friends are posting</h1>\n");
      out.write("\t\t\t\t\t<p>Whether you're browsing youtube.com or its mobile app, when\n");
      out.write("\t\t\t\t\t\tyou're signed in with your Google Account, you can see videos\n");
      out.write("\t\t\t\t\t\trecommended for you.</p>\n");
      out.write("\t\t\t\t</div></li>\n");
      out.write("\t\t\t<li><a href=\"#tip8\">Tip 1: See What videos your friends are\n");
      out.write("\t\t\t\t\tposting and adjust friendships accordingly.</a>\n");
      out.write("\n");
      out.write("\t\t\t\t<div id=\"tip8\" class=\"tip\">\n");
      out.write("\t\t\t\t\t<h1>See What videos your friends are posting</h1>\n");
      out.write("\t\t\t\t\t<p>Whether you're browsing youtube.com or its mobile app, when\n");
      out.write("\t\t\t\t\t\tyou're signed in with your Google Account, you can see videos\n");
      out.write("\t\t\t\t\t\trecommended for you.</p>\n");
      out.write("\t\t\t\t</div></li>\n");
      out.write("\t\t\t<li><a href=\"#tip9\">Tip 1: See What videos your friends are\n");
      out.write("\t\t\t\t\tposting and adjust friendships accordingly.</a>\n");
      out.write("\n");
      out.write("\t\t\t\t<div id=\"tip9\" class=\"tip\">\n");
      out.write("\t\t\t\t\t<h1>See What videos your friends are posting</h1>\n");
      out.write("\t\t\t\t\t<p>Whether you're browsing youtube.com or its mobile app, when\n");
      out.write("\t\t\t\t\t\tyou're signed in with your Google Account, you can see videos\n");
      out.write("\t\t\t\t\t\trecommended for you.</p>\n");
      out.write("\t\t\t\t</div></li>\n");
      out.write("\t\t\t<li><a href=\"#tip10\">Tip 1: See What videos your friends are\n");
      out.write("\t\t\t\t\tposting and adjust friendships accordingly.</a>\n");
      out.write("\n");
      out.write("\t\t\t\t<div id=\"tip10\" class=\"tip\">\n");
      out.write("\t\t\t\t\t<h1>See What videos your friends are posting</h1>\n");
      out.write("\t\t\t\t\t<p>Whether you're browsing youtube.com or its mobile app, when\n");
      out.write("\t\t\t\t\t\tyou're signed in with your Google Account, you can see videos\n");
      out.write("\t\t\t\t\t\trecommended for you.</p>\n");
      out.write("\t\t\t\t</div></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div>\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\t$(document).ready(function() {\n");
      out.write("\t\t\t$(\".tips\").tip_cards({\n");
      out.write("\t\t\t    entrance: \"bottom\",\n");
      out.write("\t\t\t    column: 4, \n");
      out.write("\t\t\t    margin: \"1%\",\n");
      out.write("\t\t\t    selector: \"> li\", \n");
      out.write("\t\t\t    hoverTilt: \"right\",\n");
      out.write("\t\t\t    triggerSelector: \"> li a\", \n");
      out.write("\t\t\t    cardFlyDirection: \"all\",\n");
      out.write("\t\t\t    closeButton: \"X\", \n");
      out.write("\t\t\t    flipButton: \"Flip\",\n");
      out.write("\t\t\t    navigation: true,\n");
      out.write("\t\t\t    beforeOpen: null,\n");
      out.write("\t\t\t    afterOpen: null\n");
      out.write("\t\t\t  });\n");
      out.write("\t\t});\n");
      out.write("\t</script>\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/view/TipCards.jsp(13,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/resources/css/default.css");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /WEB-INF/view/TipCards.jsp(18,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/resources/js/jquery.tip_cards.js");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /WEB-INF/view/TipCards.jsp(20,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/resources/css/tip_cards.css");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f3.setParent(null);
    // /WEB-INF/view/TipCards.jsp(22,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/resources/css/style.css");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f4.setParent(null);
    // /WEB-INF/view/TipCards.jsp(24,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/resources/css/elusive-webfont.css");
    int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
    if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
    return false;
  }
}