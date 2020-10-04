console.log('form sign up');

document.getElementById('btn_Submit').addEventListener('click', () => {
    let firstName = document.getElementById('firstName').value;
    let lastName = document.getElementById('lastName').value;
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let cofirmPassword = document.getElementById('cofirmPassword').value;
    let male = document.getElementById('male');
    console.log(firstName, lastName, username, password, cofirmPassword, male.checked ? 'male' : 'female');
    axios({
        method: 'POST',
        url: 'http://localhost:8080/Social-Original/api/admin/user',
        data: {
            name: `${firstName} ${lastName}`,
            gioiTinh: male.checked ? 'male' : 'female',
            password: password,
            userName: username,
            rePassword: cofirmPassword
        },
    }).then(function (res) {
        console.log(res.status, 'thành công');
        swal(" Thành công  !", {
            icon: "success",
        }).then(() => {
            window.location = "../login/signIn.html";
        });
    }).catch(function (err) {
        console.log(err.status);
    })
});