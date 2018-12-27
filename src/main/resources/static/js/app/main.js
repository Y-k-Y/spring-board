var main={
    init : function(){
        var _this = this; // main 객체를 this로 받아서 _this에 대입시킨다.
        $('#btn-save').on('click', function(){
            _this.save(); // main 객체의 save 함수 즉, main.save()를 실행시키는 과정
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
    }

};

main.init();