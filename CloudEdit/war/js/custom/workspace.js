/**
 * 
 */
  $(function() {
	
	/* ----------------- layout --------------------- */
	$('.layout').height(window.innerHeight * 0.9);
	
    /* ----------------- panels --------------------- */
    var minWidth = 280;
    $(".resizable1").resizable({
      autoHide: false,
      handles: 'e',
      minWidth: minWidth,
      resize: function(e, ui){
        var parentWidth = ui.element.parent().width();
        var remainingSpace = parentWidth - ui.element.outerWidth();
        
        if(remainingSpace < minWidth){
          ui.element.width((parentWidth - minWidth)/parentWidth*100+"%");
          remainingSpace = minWidth;
        }
        var divTwo = ui.element.next(),
            divTwoWidth = (remainingSpace - (divTwo.outerWidth() - divTwo.width()))/parentWidth*100+"%";
        divTwo.width(divTwoWidth);
      },
      stop: function(e, ui){
        var parentWidth = ui.element.parent().width();
        ui.element.css({
          width: ui.element.width()/parentWidth*100+"%"
        });
      }
    });
    
    $( "#canvas" ).resizable({
    });
    
    /* ----------------- toolbar --------------------- */
    $("#btnOpen").button({
    	icons: {
            primary: "ui-icon-folder-open"
          }
    });
    $( "#btnOpen" )
      .button()
      .click(function() {
        alert( "Default open" );
      })
      .next()
        .button({
          text: false,
          icons: {
            primary: "ui-icon-triangle-1-s"
          }
        })
        .click(function() {
          var menu = $( this ).parent().next().show().position({
            my: "left top",
            at: "left bottom",
            of: this
          });
          $( document ).one( "click", function() {
            menu.hide();
          });
          return false;
        })
        .parent()
          .buttonset()
          .next()
            .hide()
            .menu();
    
    choose_options = {
    	    success: function(files) {
    	      files.forEach(function(file) {
    	        upload_image(file.link);
    	      });
    	    },
    	    cancel: function() {
    	      //optional
    	    },
    	    linkType: "direct", // "preview" or "direct"
    	    multiselect: false, // true or false
    	    extensions: ['.bmp', '.png', '.jpg'],
    	};
    
    $("#openUrl").click( function() {
    	var url = prompt("Please enter an url");
    	upload_image(url);
    });
    
    $("#openDropbox").click( function() {
    	Dropbox.choose(choose_options);
    });
    
    function upload_image(src) {
    	$.get('upload', {"src": src},
                function(resp) { // on sucess
    				display_image(resp);
                })
                .fail(function() { // on failure
                    alert("Request failed.");
                });
    }
    
    function display_image(json) {
		var jsonObj = $.parseJSON(json);
		var src = jsonObj['url'];
  	  	
		var canvas = document.getElementById("canvas");
  	  	var image = canvas.getElementsByTagName("img")[0];
  	  	image.src = src;
  	    image.onload = function() {
  	    	$( "#spinner-resize-height" ).spinner("value", image.naturalHeight );
  	    	$( "#spinner-resize-width" ).spinner("value", image.naturalWidth );
  	    }
    }
    
    $("#btnSave").button({
    	icons: {
            primary: "ui-icon-disk"
          }
    });
    $( "#btnSave" )
    .button()
    .click(function() {
      alert( "Default save" );
    })
    .next()
      .button({
        text: false,
        icons: {
          primary: "ui-icon-triangle-1-s"
        }
      })
      .click(function() {
        var menu = $( this ).parent().next().show().position({
          my: "left top",
          at: "left bottom",
          of: this
        });
        $( document ).one( "click", function() {
          menu.hide();
        });
        return false;
      })
      .parent()
        .buttonset()
        .next()
          .hide()
          .menu();
    
    var save_options = {

    	    // Success is called once all files have been successfully added to the user's
    	    // Dropbox, although they may not have synced to the user's devices yet.
    	    success: function () {
    	        // Indicate to the user that the files have been saved.
    	        alert("Success! Files saved to your Dropbox.");
    	    },

    	    // Progress is called periodically to update the application on the progress
    	    // of the user's downloads. The value passed to this callback is a float
    	    // between 0 and 1. The progress callback is guaranteed to be called at least
    	    // once with the value 1.
    	    progress: function (progress) {
    	    	
    	    },

    	    // Cancel is called if the user presses the Cancel button or closes the Saver.
    	    cancel: function () {
    	    	
    	    },

    	    // Error is called in the event of an unexpected response from the server
    	    // hosting the files, such as not being able to find a file. This callback is
    	    // also called if there is an error on Dropbox or if the user is over quota.
    	    error: function (errorMessage) {
    	    	
    	    }
    	};
    
    $("#saveDropbox").click( function() {
    	var src = $("#canvas_img").attr("src");
    	var filename = src.substring( src.lastIndexOf('/')+1, src.length);
    	Dropbox.save(src, filename, save_options);
    });
    
    $("#saveLocal").click( function() {
    	var link = document.createElement('a');
    	var href = $("#canvas_img").attr("src");
    	var download = href.substring( href.lastIndexOf('/')+1, href.length);
    	link.setAttribute("href", href);
    	link.setAttribute("download", download);
    	link.click();
    });
    
	/* ----------------- accordion --------------------- */
    $( "#accordion" ).accordion({
    	  heightStyle: "fill"
    });
    
	/* ----------------- Basic --------------------- */
    $( "#list_basic" ).selectable();
    
	/* ----------------- Auto Adjust --------------------- */
    $("#btn-autoAdjust").button({
    	icons: {
            primary: "ui-icon-star"
          }
    });
    $("#btn-autoAdjust").click( function(event) {
    	var img_src = $("#canvas_img").attr("src");
    	$.get('improve', { "src": img_src },
            function(resp) { // on sucess
				display_image(resp);
            })
            .fail(function() { // on failure
                alert("Request failed.");
            });	
    });
    
	/* ----------------- Rotate --------------------- */
    $("#btn-rotate-apply").button({
    	icons: {
            primary: "ui-icon-circle-arrow-e"
          },
        text: false
    });
    $("#btn-rotate-apply").click( function(event) {
    	var img_src = $("#canvas_img").attr("src");
    	var angle = $("#slider-rotate").slider( "value" );
    	$.get('rotate', { "src": img_src, "angle": angle},
                function(resp) { // on sucess
    				display_image(resp);
                })
                .fail(function() { // on failure
                    alert("Request failed.");
                });
    });
       
    $( "#slider-rotate" ).slider({
        range: "max",
        min: 0,
        max: 270,
        step: 90,
        value: 0,
        slide: function( event, ui ) {
          $( "#rotate-amount" ).val( ui.value );
        }
      });
    $( "#rotate-amount" ).val( $( "#slider-rotate" ).slider( "value" ) );

	/* ----------------- Resize --------------------- */
    $("#btn-resize-apply").button({
    	icons: {
            primary: "ui-icon-circle-arrow-e"
          },
        text: false
    });
    $("#btn-resize-apply").click( function(event) {
    	var img_src = $("#canvas_img").attr("src");
    	var width = $("#spinner-resize-width").spinner( "value" );
    	var height = $("#spinner-resize-height").spinner( "value" );
    	
    	$.get('resize', { "src": img_src, "width": width, "height": height },
                function(resp) { // on sucess
    				display_image(resp);
                })
                .fail(function() { // on failure
                    alert("Request failed.");
                });
    });
    $( "#spinner-resize-height" ).spinner();
    $( "#spinner-resize-width" ).spinner();
    
    $( "#slider-resize" ).slider({
        range: "max",
        min: 0,
        max: 1,
        step: 0.1,
        value: 1,
        slide: function( event, ui ) {
          $( "#resize-amount" ).val( ui.value );

  		  var canvas = document.getElementById("canvas");
  	  	  var image = canvas.getElementsByTagName("img")[0];
  	  	  
  	  	  if(image != null) {
  	  		  $("#spinner-resize-width").spinner( "value", ui.value *  image.naturalWidth );
  	  		  $("#spinner-resize-height").spinner( "value", ui.value * image.naturalHeight );  
  	  	  }
        }
      });
    $( "#resize-amount" ).val( $( "#slider-resize" ).slider( "value" ) );

	/* ----------------- Exposure --------------------- */
    $( "#slider-brightness" ).slider({
        range: "max",
        min: -100,
        max: 100,
        step: 10,
        value: 0,
        slide: function( event, ui ) {
          $( "#brightness-amount" ).val( ui.value );
        }
      });
    $( "#brightness-amount" ).val( $( "#slider-brightness" ).slider( "value" ) );
    
    $( "#slider-contrast" ).slider({
        range: "max",
        min: -100,
        max: 100,
        step: 10,
        value: 0,
        slide: function( event, ui ) {
          $( "#contrast-amount" ).val( ui.value );
        }
      });
    $( "#contrast-amount" ).val( $( "#slider-contrast" ).slider( "value" ) );

    $("#btn-exposure-apply").button({
    	icons: {
            primary: "ui-icon-circle-arrow-e"
          },
        text: false
    });
    $("#btn-exposure-apply").click( function(event) {
    	var img_src = $("#canvas_img").attr("src");
    	var brightness_level = $("#slider-brightness").slider( "value" );
    	var contrast_level = $("#slider-contrast").slider( "value" );
    	
    	$.get('exposure', { "src": img_src, "brightness": brightness_level, "contrast": contrast_level},
                function(resp) { // on sucess
    				display_image(resp);
                })
                .fail(function() { // on failure
                    alert("Request failed.");
                });
    });

	/* ----------------- Colors --------------------- */
    $("#btn-color-apply").button({
    	icons: {
            primary: "ui-icon-circle-arrow-e"
          },
        text: false
    });
    $("#btn-color-apply").click( function(event) {
    	var img_src = $("#canvas_img").attr("src");
    	var r = $("#slider-red").slider( "value" );
    	var g = $("#slider-green").slider( "value" );
    	var b = $("#slider-blue").slider( "value" );
    	
    	$.get('color', { "src": img_src, "r": r, "g": g, "b": b},
                function(resp) { // on sucess
    				display_image(resp);
                })
                .fail(function() { // on failure
                    alert("Request failed.");
                });
    });
    
    $( "#slider-red" ).slider({
        range: "max",
        min: -100,
        max: 100,
        step: 10,
        value: 0,
        slide: function( event, ui ) {
          $( "#red-amount" ).val( ui.value );
        }
      });
    $( "#red-amount" ).val( $( "#slider-red" ).slider( "value" ) );
    
    $( "#slider-green" ).slider({
        range: "max",
        min: -100,
        max: 100,
        step: 10,
        value: 0,
        slide: function( event, ui ) {
          $( "#green-amount" ).val( ui.value );
        }
      });
    $( "#green-amount" ).val( $( "#slider-green" ).slider( "value" ) );
    
    $( "#slider-blue" ).slider({
        range: "max",
        min: -100,
        max: 100,
        step: 10,
        value: 0,
        slide: function( event, ui ) {
          $( "#blue-amount" ).val( ui.value );
        }
      });
    $( "#blue-amount" ).val( $( "#slider-blue" ).slider( "value" ) );
    
	/* ----------------- HSV --------------------- */
    $("#btn-hsv-apply").button({
    	icons: {
            primary: "ui-icon-circle-arrow-e"
          },
        text: false
    });
    $("#btn-hsv-apply").click( function(event) {
    	var img_src = $("#canvas_img").attr("src");
    	var saturation = $("#slider-saturation").slider( "value" );
    	var hue = $("#slider-hue").slider( "value" );
    	
    	$.get('hsv', { "src": img_src, "saturation": saturation, "hue": hue },
                function(resp) { // on sucess
    				display_image(resp);
                })
                .fail(function() { // on failure
                    alert("Request failed.");
                });
    });
    
    $( "#slider-saturation" ).slider({
        range: "max",
        min: -100,
        max: 100,
        step: 10,
        value: 0,
        slide: function( event, ui ) {
          $( "#saturation-amount" ).val( ui.value );
        }
      });
    $( "#saturation-amount" ).val( $( "#slider-saturation" ).slider( "value" ) );
    
    $( "#slider-hue" ).slider({
        range: "max",
        min: -100,
        max: 100,
        step: 10,
        value: 0,
        slide: function( event, ui ) {
          $( "#hue-amount" ).val( ui.value );
        }
      });
    $( "#hue-amount" ).val( $( "#slider-hue" ).slider( "value" ) );
    
	/* ----------------- Effects --------------------- */
    $( "#list_effect" ).selectable();
    

    
	/* ----------------- grayscale --------------------- */
    $("#btn-grayscale").button({
    	icons: {
            primary: "ui-icon-circle-arrow-e"
          },
        text: false
    });
    $("#btn-grayscale").click( function(event) {
    	var img_src = $("#canvas_img").attr("src");
    	$.get('effects', { "src": img_src, "type": "grayscale"},
                function(resp) { // on sucess
    				display_image(resp);
                })
                .fail(function() { // on failure
                    alert("Request failed.");
                });
    });

	/* ----------------- negate --------------------- */
    $("#btn-negate").button({
    	icons: {
            primary: "ui-icon-circle-arrow-e"
          },
        text: false
    });
    $("#btn-negate").click( function(event) {
    	var img_src = $("#canvas_img").attr("src");
    	$.get('effects', { "src": img_src, "type": "negate"},
                function(resp) { // on sucess
    				display_image(resp);
                })
                .fail(function() { // on failure
                    alert("Request failed.");
                });
    });
    
	/* ----------------- vignette --------------------- */
    $("#btn-vignette").button({
    	icons: {
            primary: "ui-icon-circle-arrow-e"
          },
        text: false
    });
    $("#btn-vignette").click( function(event) {
    	var img_src = $("#canvas_img").attr("src");
    	$.get('effects', { "src": img_src, "type": "vignette"},
                function(resp) { // on sucess
    				display_image(resp);
                })
                .fail(function() { // on failure
                    alert("Request failed.");
                });
    });

	/* ----------------- oildpaint --------------------- */
    $("#btn-oilpaint").button({
    	icons: {
            primary: "ui-icon-circle-arrow-e"
          },
        text: false
    });
    $("#btn-oilpaint").click( function(event) {
    	var img_src = $("#canvas_img").attr("src");
    	$.get('effects', { "src": img_src, "type": "oil_paint"},
                function(resp) { // on sucess
    				display_image(resp);
                })
                .fail(function() { // on failure
                    alert("Request failed.");
                });
    });

	/* ----------------- gradient fade --------------------- */
    $("#btn-gradient-fade").button({
    	icons: {
            primary: "ui-icon-circle-arrow-e"
          },
        text: false
    });
    $("#btn-gradient-fade").click( function(event) {
    	var img_src = $("#canvas_img").attr("src");
    	$.get('effects', { "src": img_src, "type": "gradient_fade"},
                function(resp) { // on sucess
    				display_image(resp);
                })
                .fail(function() { // on failure
                    alert("Request failed.");
                });
    });
    
	/* ----------------- sepia --------------------- */
    $("#btn-sepia").button({
    	icons: {
            primary: "ui-icon-circle-arrow-e"
          },
        text: false
    });
    $("#btn-sepia").click( function(event) {
    	var img_src = $("#canvas_img").attr("src");
    	$.get('effects', { "src": img_src, "type": "sepia"},
                function(resp) { // on sucess
    				display_image(resp);
                })
                .fail(function() { // on failure
                    alert("Request failed.");
                });
    });
    
	/* ----------------- pixelate --------------------- */
    $("#btn-pixelate-apply").button({
    	icons: {
            primary: "ui-icon-circle-arrow-e"
          },
        text: false
    });
    $("#btn-pixelate-apply").click( function(event) {
    	var img_src = $("#canvas_img").attr("src");
    	var value = $("#slider-pixelate").slider( "value" );
    	$.get('effects', { "src": img_src, "type": "pixelate", "pixelation": value },
                function(resp) { // on sucess
    				display_image(resp);
                })
                .fail(function() { // on failure
                    alert("Request failed.");
                });
    });
    
    $( "#slider-pixelate" ).slider({
        range: "max",
        min: 1,
        max: 100,
        step: 1,
        value: 1,
        slide: function( event, ui ) {
          $( "#pixelate-amount" ).val( ui.value );
        }
      });
    $( "#pixelate-amount" ).val( $( "#slider-pixelate" ).slider( "value" ) );
    
	/* ----------------- blur --------------------- */
    $("#btn-blur-apply").button({
    	icons: {
            primary: "ui-icon-circle-arrow-e"
          },
        text: false
    });
    $("#btn-blur-apply").click( function(event) {
    	var img_src = $("#canvas_img").attr("src");
    	var level = $("#slider-blur").slider( "value" );
    	$.get('effects', { "src": img_src, "type": "blur", "level": level },
                function(resp) { // on sucess
    				display_image(resp);
                })
                .fail(function() { // on failure
                    alert("Request failed.");
                });
    });
    
    $( "#slider-blur" ).slider({
        range: "max",
        min: -100,
        max: 100,
        step: 10,
        value: 0,
        slide: function( event, ui ) {
          $( "#blur-amount" ).val( ui.value );
        }
      });
    $( "#blur-amount" ).val( $( "#slider-blur" ).slider( "value" ) );
    
	/* ----------------- sharpen --------------------- */
    $("#btn-sharpen-apply").button({
    	icons: {
            primary: "ui-icon-circle-arrow-e"
          },
        text: false
    });
    $("#btn-sharpen-apply").click( function(event) {
    	var img_src = $("#canvas_img").attr("src");
    	var level = $("#slider-sharpen").slider( "value" );
    	$.get('effects', { "src": img_src, "type": "sharpen", "level": level },
                function(resp) { // on sucess
    				display_image(resp);
                })
                .fail(function() { // on failure
                    alert("Request failed.");
                });
    });
    
    $( "#slider-sharpen" ).slider({
        range: "max",
        min: -100,
        max: 100,
        step: 10,
        value: 0,
        slide: function( event, ui ) {
          $( "#sharpen-amount" ).val( ui.value );
        }
      });
    $( "#sharpen-amount" ).val( $( "#slider-sharpen" ).slider( "value" ) );
    
	/* ----------------- frame / overlay --------------------- */
    $( "#list_overlay" ).selectable();
    
	/* ----------------- frame --------------------- */
    $("#btn-frame").button({
    	icons: {
            primary: "ui-icon-circle-arrow-e"
          },
        text: false
    });
    $("#btn-frame").click( function(event) {
    	var img_src = $("#canvas_img").attr("src");
    	var pixel = $("#slider-frame-border").slider( "value" );
    	var color = currentHex;
    	
    	$.get('border', { "src": img_src, "pixel": pixel, "color": color },
                function(resp) { // on sucess
    				display_image(resp);
                })
                .fail(function() { // on failure
                    alert("Request failed.");
                });
    });
    
    $( "#slider-frame-border" ).slider({
        range: "max",
        min: 5,
        max: 20,
        step: 1,
        value: 5,
        slide: function( event, ui ) {
          $( "#slider-frame-amount" ).val( ui.value );
        }
      });
    $( "#slider-frame-amount" ).val( $( "#slider-frame-border" ).slider( "value" ) );
    
    var currentHex = 'ffffff';
    $('#picker').colpick({
    	flat:true,
    	layout:'hex',
    	color: 'ffffff',
    	submit:0,
    	onChange:function(hsb,hex,rgb,el,bySetColor) {
    		currentHex = hex;
    	}
    });
    
	/* ----------------- overylay --------------------- */
    $("#btn-textoverlay").button({
    	icons: {
            primary: "ui-icon-circle-arrow-e"
          },
        text: false
    });
    $("#btn-textoverlay").click( function(event) {
//    	var img_src = $("#canvas_img").attr("src");
//    	var text = $("#text-overlay").val();
//    	var position = $("#overlay-pos-option").val();
//    	$.get('textoverlay', { "src": img_src, "text": text, "position": position },
//                function(resp) { // on sucess
//    				display_image(resp);
//                })
//                .fail(function() { // on failure
//                    alert("Request failed.");
//                });
    });
    
	/* ----------------- general --------------------- */   
    $( "input[type=submit], a, button" )
          .button()
          .click(function( event ) {
            //event.preventDefault();
    });

  });