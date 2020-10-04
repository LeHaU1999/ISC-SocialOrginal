console.log('form login');

document.getElementById('btn_login').addEventListener('click', () => {
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    console.log(username, password);
    axios({
        method: 'GET',
        url: `http://localhost:8080/Social-Original/api/admin/login/${username}/${password}`
    }).then(function (res) {
        swal(" Thành công  !", {
            icon: "success",
        }).then(() => {
            window.location = "../formmain/main.html";
            console.log(res.data, 'thành công');
            localStorage.setItem("userCurrent", JSON.stringify(res.data));
        });
    }).catch(function (err) {
        console.log(err.status);
        swal(" Tài khoản hoặc Mật khẩu  !", 'Không hợp lệ', {
            icon: "warning",
        });
    })
});
