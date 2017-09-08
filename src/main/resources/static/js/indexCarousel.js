$(document).ready(function () {

    $("#btn-blog-next").click(function () {
      $('#blogCarousel').carousel('next')
    });
     $("#btn-blog-prev").click(function () {
      $('#blogCarousel').carousel('prev')
    });

     $("#btn-client-next").click(function () {
      $('#clientCarousel').carousel('next')
    });
     $("#btn-client-prev").click(function () {
      $('#clientCarousel').carousel('prev')
    });
    
});

 $(window).load(function(){
    $('.flexslider').flexslider({
        animation: "fade",
        slideshowSpeed: 200,
        animationSpeed: 5600, 
        slideshow: true,
        start: function(slider){
          $('body').removeClass('loading');
        }
    });  
});