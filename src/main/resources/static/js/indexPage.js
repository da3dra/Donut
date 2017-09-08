$(document).ready(function () {
	$.ajax({ 
        type: "GET",
        url: "/albums/new",
        success: function (data) {
        	$.each(data.content, function(i, item) {
        		var artists = []
        		artists = item.artists;
        	/*	сделать чтобы выводил ссылки на всех артистов, не только первого*/
        		var element = '<li class="span3 gallery-item" data-id="id-1"data-type="illustration"><img src="data:image/png;base64,'+item.cover+'" alt="Gallery"/><span class="project-details"><a href="album?id='+item.id+'">'+item.title+'</a><a href="artist?id='+item.artists[0].id+'">'+item.artists[0].username+'</a></span></li>';
        		$('#new_albums').append(element);
            })
        },
        error: function (e) {
         alert('error');
        }
});
	
	$("#search_btn").click( function(event) {
		var item = $('#search').val();
		window.location.href="search?item="+item;
	});
	
});