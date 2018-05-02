<link href="css/jquery-ui.min.css" rel="stylesheet">
<link href="css/jquery.ui.plupload.css" rel="stylesheet">		
<style>
#content{
	max-width: 81vw;
    margin-left: 5px;
    padding: 0px 56px 0px 56px;
}
</style>
		<!-- upload -->
		 <!-- <div class="upload">
				<div class="upload-grids">
					<div class="upload-right" style="padding: 5em 0">
						<div class="upload-file">
							<div class="services-icon">
								<span class="glyphicon glyphicon-open" aria-hidden="true"></span>
							</div>
							<input type="file" value="Choose file..">
						</div>
						<div class="upload-info">
							<h5>Select files to upload</h5>
							<span>or</span>
							<p>Drag and drop files</p>
						</div>
					</div>
				</div>
		</div> --> 
		
		<div class="col-sm-1 "></div>
                    <div class="col-sm-11" style="padding: 0px;margin: 0px">
                       <div id="uploader">
							<p>Your browser doesn't have Flash, Silverlight or HTML5 support.</p>
						</div>
                    </div>
		
		<form class="form-horizontal" role="form" id="uploadform">
		<div class="form-group"></div>
				<div class="form-group">
                    <label for="email" class="col-sm-1 ">Title</label>
                    <div class="col-sm-11">
                        <input type="text" name="title" placeholder="Title" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="firstName" class="col-sm-1 ">Description</label>
                    <div class="col-sm-11">
                        <textarea name="description" placeholder="Description" class="form-control" autofocus></textarea>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="theme" class="col-sm-1 ">Theme</label>
                    <div class="col-sm-11">
                        <select name="theme" id="theme" class="form-control">
                            <option value="">Select Theme</option>
                            
                        </select>
                    </div>
                </div> <!-- /.form-group -->
                
                <div class="form-group">
                    <div class="col-sm-2 col-sm-offset-5">
                        <button type="submit" class="btn btn-primary btn-block">Upload</button>
                    </div>
                </div>
                <input type="hidden" name="session_id" value="">
                </form>
                <div class="main-grids">
				<div class="top-grids">
					
					
					
					<!-- <a class="callbacks_nav callbacks1_nav prev" href="#">Previous</a><a class="callbacks_nav callbacks1_nav next" href="#">Next</a> -->
					<div class="clearfix"> </div>
				</div>
				
				
				
			</div>
		<!-- //upload -->
		<script src="js/appjs/jquery-ui.min.js"></script>
		<script src="js/appjs/plupload.full.min.js"></script>
		<script src="js/appjs/jquery.ui.plupload.min.js"></script>
	
		<script type="text/javascript" >
// Initialize the widget when the DOM is ready
	$.getJSON(config.restserverUrl+"themes/all",function(data){
			$('.resent-grid','.top-grids').remove()
			data.forEach(function(theme){
				$("#theme").append(' <option value="'+theme.theme_id+'">'+theme.theme_name+'</option>')
			})
		});

	$("input[name=session_id]").val(localStorage.getItem("user_session_id"));

	$("#uploadform").validate({
		rules : {
			title : {
				required : true
			},
			theme : {
				required : true
			}
		},
		messages : {
			title : {
				required : 'Enter Title'
			},
			theme : {
				required : 'Select Theme'
			}
		},
		submitHandler : function(form,event) {
			event.preventDefault();
			var up = $('#uploader').plupload('getUploader');
	       	
	       	if ($('#uploader').plupload('getFiles').length > 0) {
	       
			  up.settings.url = config.restserverUrl+"uploadAttachment?"+$(form).serialize();

			  $('#uploader').on('complete', function(up, file) {
				  $("#uploadform")[0].reset();
  				});
			  
			  $('#uploader').plupload('start');
	       	}
		},
		// Do not change code below
		errorClass : "text-danger",
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});
	
	$(function() {
		$("#uploader").plupload({
			// General settings
			runtimes : 'html5,html4',
			url : "/examples/upload",
	
			// Maximum file size
			max_file_size : '150mb',
	
			//chunk_size: '1mb',
			
			// Resize images on clientside if we can
			resize : {
				width : 400, 
				height : 400, 
				quality : 90,
				crop: true // crop to exact dimensions
			},
			max_file_count: 0,
			// Specify what files to browse for
			filters : [
				{title : "Image files", extensions : "mp4,mov"},
				/* {title : "Zip files", extensions : "zip,avi"} */
			],
	
			// Rename files by clicking on their titles
			rename: true,

			multipart:true,
			
			// Sort files
			sortable: true,
	
			// Enable ability to drag'n'drop files onto the widget (currently only HTML5 supports that)
			dragdrop: true,
			
			// Views to activate
			views: {
				list: true,
				thumbs: true, // Show thumbs
				active: 'thumbs'
			},
	
			// Flash settings
			//flash_swf_url : '/plupload/js/Moxie.swf',
		
			// Silverlight settings
			//silverlight_xap_url : '/plupload/js/Moxie.xap'
		});
	});
</script>
		