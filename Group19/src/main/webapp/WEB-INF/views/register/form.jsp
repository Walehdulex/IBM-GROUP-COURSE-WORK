<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="../../../static/forms.css">
</head>
<body>
<div class="container">
    <h2>Registration</h2>

    <form:form action="/addUser" modelAttribute="user">
        Username:
        <form:input path="username"/>
        <form:errors path="username"/><br/>
        Name:
        <form:input path="name"/>
        <form:errors path="name"/><br/>
        Password:
        <form:input path="password"/>
        <form:errors path="password"/><br/>
        <input value="Register" type="submit"/>
        <div class="link">
            <a href="/login">Already have an account?</a>
        </div>
    </form:form>
</div>
</body>
</html>