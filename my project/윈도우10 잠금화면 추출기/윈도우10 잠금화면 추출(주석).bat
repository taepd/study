rem 윈도우10 잠금화면 추출

rem 아래 "사용자명"에 자신의 윈도우 사용자명 입력. (예시: set 사용자명=용주)

set username=사용자명

rem 아래 "저장폴더경로" 부분에 저장폴더 경로 입력. (예시: set folder=C:\Users\abc\바탕 화면\저장폴더) 
rem 현재 폴더 자동생성 안되므로 미리 만들어 둘 것

set folder=저장폴더경로	

copy "C:\Users\%username%\AppData\Local\Packages\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\LocalState\Assets" "%folder%"

forfiles /p "%folder%" /C "cmd /c if @fsize LEQ 200000 del @path"

ren "%folder%\*.*" *.jpg

%SystemRoot%\explorer.exe "%folder%"