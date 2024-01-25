$ErrorActionPreference = 'Stop'

$fileName  = 'umple-win.zip'
$toolsPath = Split-Path $MyInvocation.MyCommand.Definition
$zip_path = "$toolsPath\$fileName"
Get-ChildItem $toolsPath\* | Where-Object { $_.PSIsContainer } | Remove-Item -Force -Recurse

$packageArgs = @{
    PackageName  = 'umple'
    FileFullPath = $zip_path
    Destination  = $toolsPath
}
Get-ChocolateyUnzip @packageArgs
Remove-Item $zip_path -ea 0
Install-BinFile -Name 'umple' -Path "$toolsPath\umple.bat"
