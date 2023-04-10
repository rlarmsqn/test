$(document).ready(function () {
    $("#callAjax").click(function () {
        let token = $("meta[name='_csrf']").attr("content")
        let header = $("meta[name='_csrf_header']").attr("content")
        let name = "boo"
        console.log("token ", token)
        console.log("header ", header)
        $.ajax({
            type: 'POST',
            contentType: "application/json",
            url: "/csrf",
            data: JSON.stringify({"name": name}),
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token)
            },
            success: function (res) {
                console.log("성공 ",res)
            },
            error: function (res) {
                console.log("실패 ", res)
            }
        })
    })
})
