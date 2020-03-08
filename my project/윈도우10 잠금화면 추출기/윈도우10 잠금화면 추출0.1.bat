copy "C:\Users\taepd\AppData\Local\Packages\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\LocalState\Assets" "C:\Users\taepd\OneDrive\바탕 화면\임시저장소"

forfiles /p "C:\Users\taepd\OneDrive\바탕 화면\임시저장소" /C "cmd /c if @fsize LEQ 200000 del @path"

ren "C:\Users\taepd\OneDrive\바탕 화면\임시저장소\*.*" *.png

%SystemRoot%\explorer.exe "C:\Users\taepd\OneDrive\바탕 화면\임시저장소"

