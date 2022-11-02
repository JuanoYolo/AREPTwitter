var Client = (function () {
    var url = "localhost:4567";

    function theUrl() {
        axios.get(url + "/information").then(res => {
                console.log(url + "/information")
                $("#information").text(res.data);
            }
        )
    }

    function login() {
        var user = {email: document.getElementById("username").value, password: document.getElementById("password").value}
        axios.post(url + "/login", user).then(res => {
            window.location.href = "accessGranted.html";
        })
    }

    return {
        login: login,
        info: info
    };
})
();