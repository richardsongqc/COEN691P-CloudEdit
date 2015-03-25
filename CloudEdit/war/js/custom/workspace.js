/**
 * 
 */
  $(function() {
	
	/* ----------------- layout --------------------- */
	$('.layout').height($(document).height() * 0.95);
	
    /* ----------------- panels --------------------- */
    var minWidth = 200;
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
    	        upload_image(file);
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
      
    function upload_image(file) {
    	var src = file.link;
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
    }
    
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
    	  heightStyle: "fill",
    });
    
	/* ----------------- section: Basic --------------------- */
    $( "#list_basic" ).selectable();
    
	/* ----------------- Operation: Auto Adjust --------------------- */
    $("#btn-autoAdjust").click( function(event) {
    	// Get the button id, as we will pass it to the servlet
    	// using a GET request and it will be used to get different
    	// results (bands OR bands and albums).
    	var buttonID = event.target.id;
    	
    	// Basic JQuery Ajax GET request. We need to pass 3 arguments:
    	// 		1. The servlet url that we will make the request to.
    	//		2. The GET data (in our case just the button ID).
    	//		3. A function that will be triggered as soon as the request is successful.
    	// Optionally, you can also chain a method that will handle the possibility
    	// of a failed request.
    	$.get('AutoAdjust', {"button-id": buttonID},
            function(resp) { // on sucess
    			// We need 2 methods here due to the different ways of 
    			// handling a JSON object.
    			if (buttonID === "bands")
    				printBands(resp);
    			else if (buttonID === "bands-albums")
    				printBandsAndAlbums(resp); 
            })
            .fail(function() { // on failure
                alert("Request failed.");
            });
    			
    });
    
	/* ----------------- Operation: rotate --------------------- */
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
        max: 360,
        value: 0,
        slide: function( event, ui ) {
          $( "#rotate-amount" ).val( ui.value );
        }
      });
    $( "#rotate-amount" ).val( $( "#slider-rotate" ).slider( "value" ) );

    $( "#spinner-resize-height" ).spinner();
    $( "#spinner-resize-width" ).spinner();
    

    $( "input[type=submit], a, button" )
          .button()
          .click(function( event ) {
            //event.preventDefault();
    });

  });