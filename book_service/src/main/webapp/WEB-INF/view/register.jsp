<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="resources/css/main.css">

<style type="text/css"></style>
<title>Registration</title>
</head>
<body>
	<div class="container register-form">
		<div class="form">
			<div class="note">
				<p>Please add product</p>
			</div>

			<div class="form-content">
				<form action="/addBook" method="post" enctype="multipart/form-data">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control" inputmode="text" name="product_name"
									placeholder="Product Name *" value="" />
							</div>
							<div class="form-group">
								<input type="text" class="form-control" name="product_price" inputmode="numeric"
									placeholder="Product Price *" value="" />
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<p>
									<input id="product_image" type="file" name="book_image"
										onchange="updateSize();"> selected files: <span
										id="fileNum">0</span>; total size: <span id="fileSize">0</span>
								</p>
							</div>

						</div>
						<button type="submit" class="btnSubmit">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
            function updateSize() {
                var nBytes = 0,
                        oFiles = document.getElementById("fileInput").files,
                        nFiles = oFiles.length;
                for (var nFileId = 0; nFileId < nFiles; nFileId++) {
                    nBytes += oFiles[nFileId].size;
                }

                var sOutput = nBytes + " bytes";
                // optional code for multiples approximation
                for (var aMultiples = ["KiB", "MiB", "GiB", "TiB", "PiB", "EiB", "ZiB", "YiB"], nMultiple = 0, nApprox = nBytes / 1024; nApprox > 1; nApprox /= 1024, nMultiple++) {
                    sOutput = nApprox.toFixed(3) + " " + aMultiples[nMultiple] + " (" + nBytes + " bytes)";
                }
                // end of optional code

                document.getElementById("fileNum").innerHTML = nFiles;
                document.getElementById("fileSize").innerHTML = sOutput;
            }
        </script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>