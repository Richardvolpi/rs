Attribute VB_Name = "Module1"
Public Declare Sub loadDictionary Lib "ocrdll.dll" (ByVal strPath As String)
Public Declare Sub loadModel Lib "ocrdll.dll" (ByVal strPath As String)
Public Declare Sub getString Lib "ocrdll.dll" (ByVal strFileName As String, ByVal strWord As String)
Public Declare Function LoadLibrary Lib "kernel32" Alias "LoadLibraryA" (ByVal lpLibFileName As String) As Long
Public Declare Function FreeLibrary Lib "kernel32" (ByVal hLibModule As Long) As Long

Public lngOcr As Long
Public word As String * 32768

Public Sub Main()
    word = String(32768, 1)
    lngOcr = LoadLibrary(App.Path & "\ocrdll.dll")
    loadDictionary App.Path & "\wrds.txt"
    loadModel App.Path & "\model.txt"
    getString App.Path & "\hc.bmp", word
    MsgBox word
    Call FreeLibrary(lngOcr)
End Sub

