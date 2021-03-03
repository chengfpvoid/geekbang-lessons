<%--
  Created by IntelliJ IDEA.
  User: Cheng
  Date: 2021/3/3
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>

<jsp:directive.include file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
<%
    request.setCharacterEncoding("utf-8") ;			// 按中文接收
    String info = (String) request.getAttribute("info");		// 接收表单参数

%>
<h2><%=info%></h2>


<body>

</body>

