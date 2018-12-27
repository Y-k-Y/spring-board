var main={
    init : function(){
        var _this = this; // main 객체를 this로 받아서 _this에 대입시킨다.
        $('#btn-save').on('click', function(){
            _this.save(); // main 객체의 save 함수 즉, main.save()를 실행시키는 과정
        });
        $('.td-title').on('click', function(){
            _this.read(this);
        })
    },
    save : function(){
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        console.log(data);

        $.ajax({
            type: 'POST',
            url: '/board/posts',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 등록되었습니다.');
            location.reload();
        }).fail(function(error){
            console.log('An Exception occurred...');
            alert(error);
        });
    },
    read : function(td){
        var title = $(td).text();
        var author = $(td).next().text();
        var content = $(td).next().next().next().text();

        var modal = "<div class=\"modal fade\" id=\"postsDetail\" tabindex=\"1\" role=\"dialog\" aria-labelledby=\"postsDetail\" aria-hidden=\"true\">\n" +
            "        <div class=\"modal-dialog\" role=\"document\">\n" +
            "            <div class=\"modal-content\">\n" +
            "                <div class=\"modal-header\">\n" +
            "                    <h5 class=\"modal-title\" id=\"postsDetailLabel1\">게시글 내용</h5>\n" +
            "                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
            "                        <span aria-hidden=\"true\">&times;</span>\n" +
            "                    </button>\n" +
            "                </div>\n" +
            "                <div class=\"modal-body\">\n" +
            "                    <form>\n" +
            "                        <div class=\"form-group\">\n" +
            "                            <label for=\"title\">제목</label>\n" +
            "                            <input type=\"text\" class=\"form-control\" id=\"read-title\" readonly>\n" +
            "                        </div>\n" +
            "                        <div class=\"form-group\">\n" +
            "                            <label for=\"author\">작성자</label>\n" +
            "                            <input type=\"text\" class=\"form-control\" id=\"read-author\" readonly>\n" +
            "                        </div>\n" +
            "                        <div class=\"form-group\">\n" +
            "                            <label for=\"content\">내용</label>\n" +
            "                            <textarea class=\"form-control\" id=\"read-content\" readonly>" + content + "</textarea>\n" +
            "                        </div>\n" +
            "                    </form>\n" +
            "                </div>\n" +
            "                <div class=\"modal-footer\">\n" +
            "                    <button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">확인</button>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>";

        $('#detail-point').after(modal);

        $('#read-title').val(title);
        $('#read-author').val(author);
    }

};

main.init();