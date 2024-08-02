<%@ page import="com.tap.modal.User" %>
<%@ page import="com.tap.dao.UserDao" %>
<%@ page import="com.tap.daoimpl.UserDaoImpl" %>

<%
    User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery and Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .popup-content {
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1>Welcome, <%= user.getName() %></h1>
        <p><strong>Email:</strong> <%= user.getEmail() %></p>
        <p><strong>Phone Number:</strong> <%= user.getPhonenumber() %></p>
        <p><strong>Address:</strong> <%= user.getAddress() %></p>

        <!-- Update Button -->
        <button class="btn btn-primary" data-toggle="modal" data-target="#updateModal">Update Details</button>

        <!-- Delete Form -->
        <h2 class="mt-4">Delete Your Account</h2>
        <form action="deleteUser" method="post">
            <input type="hidden" name="email" value="<%= user.getEmail() %>">
            <button type="submit" class="btn btn-danger">Delete Account</button>
        </form>
    </div>

    <!-- Modal for Update -->
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content popup-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="updateModalLabel">Update Your Details</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="updateUser" method="post">
                        <input type="hidden" name="email" value="<%= user.getEmail() %>">
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" id="name" name="name" class="form-control" value="<%= user.getName() %>" required>
                        </div>
                        <div class="form-group">
                            <label for="phonenumber">Phone Number:</label>
                            <input type="text" id="phonenumber" name="phonenumber" class="form-control" value="<%= user.getPhonenumber() %>" required>
                        </div>
                        <div class="form-group">
                            <label for="address">Address:</label>
                            <input type="text" id="address" name="address" class="form-control" value="<%= user.getAddress() %>" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Update</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
