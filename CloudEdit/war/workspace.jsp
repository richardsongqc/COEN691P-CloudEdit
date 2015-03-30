		
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/custom/workspace.js"></script>
<script src="js/colpick.js"></script>
<script type="text/javascript" src="https://www.dropbox.com/static/api/2/dropins.js" id="dropboxjs" data-app-key="0aci2snop4eu2qc"></script>

<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/custom/workspace.css">
<link rel="stylesheet" type="text/css" href="css/colpick.css">

<div class="wrap">
	<div class="workspace">
		<div class="layout resizable1">
			<div id="accordion">
			  <h3>Basic</h3>
			  <div>
			    <ol id="list_basic">
			      <li class="ui-widget-content">Quick fix
			      	<button id="btn-autoAdjust">Auto Adjust</button>
			      </li>
				  <li class="ui-widget-content">Rotate
				    <label style="display: block; margin: 10px">Angle
				  	   <input type="text" id="rotate-amount" readonly>
				  	   <div id="slider-rotate"></div>
				  	</label>
				  	<button id="btn-rotate-apply">Apply</button>
				  </li>
				  <li class="ui-widget-content">Resize
				  	<div style="margin-top: 1em; margin-left: 0.5em">
				  	<input id="spinner-resize-height" class="ui-widget-content" name="value" style="margin-bottom: 4px; height: 30px; width: 3.5em">
				  	<span>X</span>
				  	<input id="spinner-resize-width" class="ui-widget-content" name="value" style="margin-bottom: 4px; height: 30px; width: 3.5em">
				  	<label style="display: block; margin: 10px">%
				  	   <input type="text" id="resize-amount" readonly>
				  	   <div id="slider-resize"></div>
				  	</label>
				  	<button id="btn-resize-apply">Apply</button>
				  	</div>
				  </li>
				  <li class="ui-widget-content">Exposure
				    <label style="display: block; margin: 10px">Brightness
				    	<input type="text" id="brightness-amount" readonly>
						<div id="slider-brightness"></div>
					</label>
					<label style="display: block; margin: 10px">Contrast
						<input type="text" id="contrast-amount" readonly>
						<div id="slider-contrast"></div>
					</label>
					<button id="btn-exposure-apply">Apply</button>
				  </li>
				  <li class="ui-widget-content">Colors
				    <label style="display: block; margin: 10px">Red
				    	<input type="text" id="red-amount" readonly>
						<div id="slider-red"></div>
					</label>
					<label style="display: block; margin: 10px">Green
						<input type="text" id="green-amount" readonly>
						<div id="slider-green"></div>
					</label>
					<label style="display: block; margin: 10px">Blue
						<input type="text" id="blue-amount" readonly>
						<div id="slider-blue"></div>
					</label>
					<button id="btn-color-apply">Apply</button>
				  </li>
				  <li class="ui-widget-content">HSV
				  	<label style="display: block; margin: 10px">Saturation
						<input type="text" id="saturation-amount" readonly>
						<div id="slider-saturation"></div>
					</label>
				  	<label style="display: block; margin: 10px">Hue
						<input type="text" id="hue-amount" readonly>
						<div id="slider-hue"></div>
					</label>
					<button id="btn-hsv-apply">Apply</button>
				  </li>
				</ol>
			  </div>
			  <h3>Effects</h3>
			  <div>
				<ol id="list_effect">
				  <li class="ui-widget-content">Grayscale
				  	<button id="btn-grayscale">Apply</button>
				  </li>
				  <li class="ui-widget-content">Negate
				  	<button id="btn-negate">Apply</button>
				  </li>
				  <li class="ui-widget-content">Vignette
				  	<button id="btn-vignette">Apply</button>
				  </li>
				  <li class="ui-widget-content">Oil Paint
				  	<button id="btn-oilpaint">Apply</button>
				  </li>
				  <li class="ui-widget-content">Gradient Fade
				  	<button id="btn-gradient-fade">Apply</button>
				  </li>
				  <li class="ui-widget-content">Sepia
				  	<button id="btn-sepia">Apply</button>
				  </li>
				  <li class="ui-widget-content">Pixelate
				  	<label style="display: block; margin: 10px">Level
						<input type="text" id="pixelate-amount" readonly>
						<div id="slider-pixelate"></div>
					</label>
				  	<button id="btn-pixelate-apply">Apply</button>
				  </li>
				  <li class="ui-widget-content">Blur
				  	<label style="display: block; margin: 10px">Level
						<input type="text" id="blur-amount" readonly>
						<div id="slider-blur"></div>
					</label>
				    <button id="btn-blur-apply">Apply</button>
				  </li>
				  <li class="ui-widget-content">Sharpen
				    <label style="display: block; margin: 10px">Level
						<input type="text" id="sharpen-amount" readonly>
						<div id="slider-sharpen"></div>
					</label>
				    <button id="btn-sharpen-apply">Apply</button>
				  </li>
				</ol>
			  </div>
			  <h3>Overlays / Frames</h3>
			  <div>
			  	<ol id="list_overlay">
			  	  <li class="ui-widget-content">Frame
			  	  	<label style="display: block; margin: 10px">pixel
						<input type="text" id="slider-frame-amount" readonly>
						<div id="slider-frame-border"></div>
					</label>
					<label style="display: block; margin: 15px">color
					    <div id="picker"></div>
					</label>
				  	<button id="btn-frame">Apply</button>
				  </li>
				  <li class="ui-widget-content">Text overlay
				  	<label style="display: block; margin: 10px">Text
						<input type="text" id="text-overlay" style="display: block;width: 80%;">
					</label>
					<label style="display: block; margin: 10px">Position
						<select id="overlay-pos-option">
      					  <option>top</option>
					      <option>top-left</option>
					      <option>top-right</option>
					      <option selected="selected">bottom</option>
					      <option>bottom-left</option>
					      <option>bottom-right</option>
    					</select>
					</label>
				  	<button id="btn-textoverlay">Apply</button>
				  </li>
			  	</ol>
			  </div>
			</div>
		  </div>
		</div>
		<div class="layout resizable2">
			<div id="toolbar" class="workspace ui-widget-header ui-corner-all">
			  <div style="float: left; margin: 20px">
			    <button id="btnOpen">Open</button>
			    <button id="select">Select an action</button>
			  </div>
			  <ul>
			    <li id="openUrl">from URL...</li>
			    <li id="openDropbox">from Dropbox</li>
			  </ul>
			
			  <div style="margin: 20px">
			    <button id="btnSave">save</button>
			    <button id="select">Select an action</button>
			  </div>
			  <ul>
			    <li id="saveDropbox">to Dropbox</li>
			    <li id="saveLocal">to my computer</li>
			  </ul>
			</div>
		
			<div id="canvas" class="workspace ui-widget-content">
				<img id="canvas_img"/>
			</div>
		</div>  
	</div>
</div>
