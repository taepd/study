set 유저명=taepd
set 저장폴더경로=C:\Users\taepd\OneDrive\바탕 화면\임시저장소

copy "C:\Users\%유저명%\AppData\Local\Packages\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\LocalState\Assets" "%저장폴더경로%"

forfiles /p "%저장폴더경로%" /C "cmd /c if @fsize LEQ 200000 del @path"

ren "%저장폴더경로%\*.*" *.jpg

%SystemRoot%\explorer.exe "%저장폴더경로%"
