<%@ page import="org.apache.zookeeper.server.SessionTracker" %><%--
  Created by IntelliJ IDEA.
  User: Yonye
  Date: 2018/8/21
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<li class="nav-header">
    <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="../Templ/img/profile_small.jpg" />
                             </span>
        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">${requestScope.user}</strong>
                             </span> <span class="text-muted text-xs block">Art Director <b class="caret"></b></span> </span> </a>
        <ul class="dropdown-menu animated fadeInRight m-t-xs">
            <li><a href="profile.html">Profile</a></li>
            <li><a href="contacts.html">Contacts</a></li>
            <li><a href="mailbox.html">Mailbox</a></li>
            <li class="divider"></li>
            <li><a href="#" onclick="logout1()">Logout</a></li>
            <li><a href="/hello/index"></a></li>
        </ul>
    </div>
    <div class="logo-element">
        OSM
    </div>
</li>
