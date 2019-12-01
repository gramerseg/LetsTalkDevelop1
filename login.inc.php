<?php

if (isset($_POST['login-submit'])) {

    require 'dbh.inc.php';

    $username = $_POST['mailuid'];
    $password = $_POST['pwd'];

    if (empty($username) || empty($password)) {
        header("Location: ../database/signin.php?error=emptyfields");
        exit();
    }
    else{
        $sql = "SELECT * FROM users WHERE idUsername=? OR emailUsers=?;";
        $stmt = mysqli_stmt_init($conn);
        if (!mysqli_stmt_prepare($stmt, $sql)) {
            header("Location: ../database/signin.php?error=sqlerror");
            exit();
        }
        else{
            mysqli_stmt_bind_param($stmt, "ss", $username, $username);
            mysqli_stmt_execute($stmt);
            $result = mysqli_stmt_get_result($stmt);
            if ($row = mysqli_fetch_assoc($result)) {
                $pwdCheck = password_verify($password, $row['pwdUsers']);
                if ($pwdCheck == false) {
                    header("Location: ../database/signin.php?error=wrongpwd");
                    exit();
                }
    
                else if ($pwdCheck == true){
                    session_start();
                    $_SESSION['Muserid'] = $row['idUsers'];
                    $_SESSION['Musername'] = $row['idUsername'];
                    $_SESSION['Memail'] = $row['emailUsers'];
                    $_SESSION['Mpassword'] = $row['pwdUsers'];
                    
                        header("Location: ../database/success.php?login=success");
                        exit();
               
                    
                }
               

                else{
                    header("Location: ../database/signin.php?error=wrongpwd");
                    exit();
                }
            }
            else{
                header("Location: ../database/signin.php?error=nousermatches");
                exit(); 
            }
        }
    }

}
else{
    header("Location: ../database/signin.php?error=noconnection");
    exit();
}
