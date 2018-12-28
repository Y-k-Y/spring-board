var main={
    init : function() {
        /* 브라우저의 scope 는 공용으로 같이 쓰인다.
           그렇기 때문에 나중에 불리어진 JS에 main 있을 경우
           먼저 불리어진 JS의 main을 덮어쓰게 된다.
           이런 문제를 피하기 위해 this로 받아서 사용함.
         */
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('.td-title').on('click', function () {
            _this.read(this, _this);
        });
    },

    save : function(){
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

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

    read : function(td, _this){
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
            "                <div class=\"modal-footer\" id=\"modal-footer-normal\">\n" +
            "                    <button type=\"button\" class=\"btn btn-danger\" id=\"btn-delete\">삭제</button>\n" +
            "                    <button type=\"button\" class=\"btn btn-primary\" id=\"btn-modify\">수정</button>\n" +
            "                    <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">확인</button>\n" +
            "                </div>\n" +
            "                <div class=\"modal-footer\" id=\"modal-footer-modify\" hidden=\"hidden\">\n" +
            "                    <button type=\"button\" class=\"btn btn-warning\" id=\"btn-modify-cancel\">취소</button>\n" +
            "                    <button type=\"button\" class=\"btn btn-success\" id=\"btn-modify-ok\">확인</button>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>";

        $('#detail-point').after(modal);
        $('#read-title').val(title);
        $('#read-author').val(author);

        $('#btn-delete').on('click', function(){
            _this.delete($(td).prev().text());
        });

        $('#btn-modify').on('click', function(){
            document.getElementById("modal-footer-normal").hidden = true;
            document.getElementById("modal-footer-modify").hidden = false;
            document.getElementById("read-title").readOnly = false;
            document.getElementById("read-author").readOnly = false;
            document.getElementById("read-content").readOnly = false;
        });

        $('#btn-modify-cancel').on('click', function(){
            document.getElementById("modal-footer-modify").hidden = true;
            document.getElementById("modal-footer-normal").hidden = false;
            document.getElementById("read-title").readOnly = true;
            document.getElementById("read-author").readOnly = true;
            document.getElementById("read-content").readOnly = true;
        });

        $('#btn-modify-ok').on('click', function(){
            _this.modify($(td).prev().text());

        });
    },

    delete : function(posts){
        const pNum = posts;

        $.ajax({
            type: 'DELETE',
            url: '/board/' + pNum,
        }).done(function(){
            alert('글이 삭제되었습니다.');
            location.reload();
        }).fail(function(error){
            console.log('An Exception occurred...');
            alert(error);
        });
    },

    modify : function(posts){
        const pNum = posts;
        var data = {
            title: $('#read-title').val(),
            author: $('#read-author').val(),
            content: $('#read-content').val()
        };

        $.ajax({
            type: 'PUT',
            url: '/board/' + pNum,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 수정되었습니다.');
            document.getElementById("modal-footer-modify").hidden = true;
            document.getElementById("modal-footer-normal").hidden = false;
            document.getElementById("read-title").readOnly = true;
            document.getElementById("read-author").readOnly = true;
            document.getElementById("read-content").readOnly = true;
            location.reload();
        }).fail(function(error){
            console.log('An Exception occurred...');
            alert(error);
        });
    }

};

main.init();