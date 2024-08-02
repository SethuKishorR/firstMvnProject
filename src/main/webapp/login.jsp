<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery and Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body class="bg-info">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4">
                <div class="card">
                    <div class="card-body">
                        <h1 class="card-title text-center text-primary">Login</h1>
                        <% if (request.getParameter("error") != null && request.getParameter("error").equals("invalid")) { %>
                            <div class="alert alert-danger" role="alert">
                                Invalid email or password. Please try again.
                            </div>
                        <% } %>
                        <form action="login" method="post">
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" id="email" name="email" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" id="password" name="password" class="form-control" required>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Log In</button>
                        </form>
                        <div class="mt-3 text-center">
                            <p>Don't have an account?</p>
                            <a href="addUser.jsp" class="btn btn-secondary">Sign Up</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
