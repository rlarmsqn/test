$(function() {
    $("#callAjax").click(function() {
        console.log("?")
        let token = $("meta[name='_csrf']").attr("content")
        let header = $("meta[name='_csrf_header']").attr("content")
        let name = "boo"
        $.ajax({
            type: 'POST',
            contentType: "application/json",
            url: "/csrf",
            data: JSON.stringify({"name":name}),
            beforeSend: function(xhr) {
                xhr.setRequestHeader(header, token)
            },
            success: function(res) {
                console.log(res)
            },
            error: function(res) {
                console.log(res)
            }
        })
    })
})
