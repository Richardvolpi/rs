unit FormAF;

interface

uses
  Windows, Messages, SysUtils, Classes, Graphics, Controls, Forms, Dialogs,
  Buttons, StdCtrls, ExtCtrls, Mask, RzEdit, RzCmboBx;

type
  TAFForm = class(TForm)
    Panel2: TPanel;
    Panel3: TPanel;
    SpeedButton4: TSpeedButton;
    Label4: TLabel;
    SpeedButton3: TSpeedButton;
    SpeedButton1: TSpeedButton;
    Label1: TLabel;
    Label2: TLabel;
    chkPickBones: TCheckBox;
    chkPickCoins: TCheckBox;
    cmbFightMode: TRzComboBox;
    txtMinHP: TRzEdit;
    Label3: TLabel;
    procedure SpeedButton3Click(Sender: TObject);
    procedure SpeedButton1Click(Sender: TObject);
    procedure SpeedButton4Click(Sender: TObject);
    procedure FormShow(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  AFForm: TAFForm;

implementation

{$R *.DFM}

procedure TAFForm.SpeedButton3Click(Sender: TObject);
begin
  ModalResult:= idCancel;
end;

procedure TAFForm.SpeedButton1Click(Sender: TObject);
begin
  ModalResult:= idOk;
end;

procedure TAFForm.SpeedButton4Click(Sender: TObject);
begin
  Close;
end;

procedure TAFForm.FormShow(Sender: TObject);
begin
  cmbFightMode.ItemIndex:= 1;
end;

end.
