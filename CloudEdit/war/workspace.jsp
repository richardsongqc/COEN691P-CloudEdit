		
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/custom/workspace.js"></script>
<script type="text/javascript" src="https://www.dropbox.com/static/api/2/dropins.js" id="dropboxjs" data-app-key="0aci2snop4eu2qc"></script>
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/custom/workspace.css">


<div class="wrap">
	<div class="workspace">
		<div class="layout resizable1">
			<div id="accordion">
			  <h3>Basic</h3>
			  <div>
			    <ol id="list_basic" >
			      <li class="ui-widget-content">Quick fix
			      	<button id="btn-autoAdjust">Auto Adjust</button>
			      </li>
				  <li class="ui-widget-content" style="height: 150px">Rotate
					  <input type="text" id="rotate-amount" readonly style="margin-right: 1em;text-align: right; width: 100%; border:0; font-weight:bold;">
				  	<div id="slider-rotate"></div>
				  	<button id="btn-rotate-apply">Apply</button>
				  </li>
				  <li class="ui-widget-content" style="height: 150px">Resize
				  	<div style="margin-top: 1em; margin-left: 0.5em">
				  	<input id="spinner-resize-height" name="value" style="margin-bottom: 4px; height: 30px; width: 3.5em">
				  	<span>X</span>
				  	<input id="spinner-resize-width" name="value" style="margin-bottom: 4px; height: 30px; width: 3.5em">
				  	</div>
		
				  	<button id="apply-button">Apply</button>
				  </li>
				  <li class="ui-widget-content">Crop</li>
				  <li class="ui-widget-content">Crop</li>
				  <li class="ui-widget-content">Crop</li>
				  <li class="ui-widget-content">Crop</li>
				</ol>
			  </div>
			  <h3>Effects</h3>
			  <div>
		
			  </div>
			  <h3>Overlays</h3>
			  <div>

			  </div>
			  <h3>Frames</h3>
			  <div>

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
