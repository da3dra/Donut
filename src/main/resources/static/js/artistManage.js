$(document).ready(function () {
		var id = $("#user_id").text();
	$.ajax({ 
        type: "GET",
        url: "/artist/"+id+"/albums",
        success: function (data) {
        	$.each(data, function(i, item) {
        	     var toAppend;
        	 	var tracks = ""
        	 	$.each(item.tracks, function(i, track) {
        	 		tracks += track.title+" "
        	 	})
        	      toAppend += '<tr id="'+item.id+'">'+
        			'<td class="title"><span id="'+item.title+'">'+item.title+'</span></td>'+
        			'<td class="genre"><span id="'+item.genres+'">'+item.genres+'</span></td>'+
        			'<td class="tags"><span id="'+item.tags+'">'+item.tags+'</span></td>'+
        			'<td class="status"><span id="'+item.status+'">'+item.status+'</span></td>'+
        			'<td class="cover"><img class ="preview" src="data:image/png;base64,'+item.cover+'"/></td>'+
        			'<td class="tags"><span id="'+tracks+'">'+tracks+'</span></td>'+
        			'<td class="delete"><button class = "delete_btn" id="'+item.id+'">Delete</button><button class = "edit_btn" id="'+item.id+'">Edit</button></td>'+
					'</tr>';
        		 $('#albumlist').append(toAppend);
            })
        },
        error: function (e) {
         alert('get albums error');
        }
	});

	$("#wrapper_admin").on("click", ".delete_btn", function() { 
		 $("#user_id").text(this.id);	
		$.ajax({ 
	        type: "DELETE",
	        url:  "/artist/album/"+this.id,
	        success: function (data) {
	        	  location.reload();    
	        	   },
	        error: function (e) {
	         alert('delete error');
	        }
		});		
	});
	
	$("#wrapper_admin").on("click", ".edit_btn", function() {
		
		$.ajax({ 
			type : "GET",
			contentType : "application/json",
			url : "album/"+this.id,
			timeout : 600000,
			success : function(data) {
				$("#album_id").text(data.id);
				$("#title_in").val(data.title);
				$("#genres_in").val(data.genres);
				$("#tags_in").val(data.tags);
			},
			error : function(e) {
				alert("error");
			}
		});
	});
	
});



function saveAlbum() {
	var form = new FormData();
	$.each($('#cover')[0].files, function(i, file) {
	    form.append('cover', file);
	});
	 form.append('title', $("#title_in").val());
	 form.append('genres', $("#genres_in").val());
	 form.append('tags', $("#tags_in").val());

	$.each($('#tracks')[0].files, function(i, file) {
	    form.append('track'+i, file);
	});
	 var id = $("#user_id").text();	
	 var album_id = $("#album_id").text();	
	 
	$.ajax({ 
			type : "POST",
			url : "/artist/"+id+"/album/"+album_id,
			enctype: 'multipart/form-data',
			cache: false,
			data: form,
			contentType: false,
			processData: false,
			timeout : 600000,
			success : function(data) {
				 alert('succ');
				  location.reload(); 
			},
			error : function(e) {
			}
		});	
	}



		
		

