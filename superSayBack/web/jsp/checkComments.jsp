<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="list" class="java.util.ArrayList" scope="request"/>
<%@ page isELIgnored="false"%>
<%@ taglib uri="../WEB-INF/tags/c.tld" prefix="c"%>
<html>
<head>
    <title>查看用户评论</title>
</head>
<body>
<form>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td height="23">当前位置：评论查询</td>
    </tr>
</table>
<table width="100%" border="0" cellpadding="3" cellspacing="1" bgcolor="6AADD8" id="tab">
    <tr>
        <td height="25">
            <div align="center" class="text3"><font color="#1F4289">序号</font></div>
        </td>

        <td height="25">
            <div align="center" class="text3"><font color="#1F4289">团购名</font></div>
        </td>

        <td height="25">
            <div align="center" class="text3"><font color="#1F4289">评论</font></div>
        </td>

        <td height="25">
            <div align="center" class="text3"><font color="#1F4289">操作</font></div>
        </td>
    </tr>
    <%
    		String[] color = {"F1F9FC","#FFFFFF"};
      	    int j=0;
    	%>

       <c:forEach items="${requestScope.list}" var="form">
    	<c:set var="i" value="${i+1}" />

    	<%j =j+1; %>
    		<tr height="25" bgcolor="<%=color[j%2]%>" id='A<c:out value="${i-1}"/>'>
    			<td height="25"><div align ='center'>${form.id}</div></td>
    			<td height="25"><div align ='center'>${form.name}</div></td>
    			<td height="25"><div align ='center'>${form.comment}</div></td>
                <td height="25"><div align ='center'>
    					<input  type="button"  class ="button" onClick="edit(${form.id})"
    					value="编辑">
    					<input  type="button"  class ="button" onClick="del(${form.id})"
    					value="删除">
    					</div>
    			</td>

    		</tr>
       </c:forEach>
       	       <%
    		    int trCount = 10;
       	       int rcount =0;
    			if(list!= null &&!list.isEmpty()){
    			    trCount = trCount - list.size();
    			    rcount =list.size()+1;
    			}
    			 for(int i=0;i<trCount;i++){
    			%>
    			 <tr bgcolor="<%=color[(i+rcount)%2]%>"  height="25"  >
    				<td height="25" ><div align="center"></div></td>
    				<td height="25" ><div align="center"></div></td>
    				<td height="25" ><div align="center"></div></td>
    				<td height="25" ><div align="center"></div></td>
    			</tr>
               <%}%>
</table>
</form>
</body>
</html>