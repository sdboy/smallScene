<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=EmulateIE10">
  <title>实时视频</title>
  <link type="text/css" rel="stylesheet" href="../static/css/main.css" />
</head>
<body onload="init.loadOcx();" onunload="dahua.logout();">
  <div class="dahua_ocx" id="dahuaOcx">

  </div>
  <div class="control_panel" id="controlPanel">

  </div>
</body>
<script type="text/javascript" src="../static/js/lib/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="../static/js/lib/dahua/dahua.js"></script>
<script type="text/javascript" src="../static/js/app/init.js"></script>
</html>