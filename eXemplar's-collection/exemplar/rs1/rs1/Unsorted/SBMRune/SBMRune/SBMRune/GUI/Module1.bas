Attribute VB_Name = "Module1"
Sub Wait(MS As Long)
  Dim Secs As Single, Start As Double
  Secs = MS / 1000
  Start = Timer
  Do While Timer < Start + Secs
     DoEvents
  Loop
End Sub
