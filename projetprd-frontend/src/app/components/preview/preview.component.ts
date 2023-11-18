import { Component } from '@angular/core';
// import { NavbarModule, WavesModule, ButtonsModule } from 'angular-bootstrap-md'
@Component({
  selector: 'app-preview',
  templateUrl: './preview.component.html',
  styleUrls: ['./preview.component.css']
})
export class PreviewComponent {


  folders: any[] = [
    {
        "id": 4,
        "folderName": "name",
        "parentFolderid": 3
    },
    {
        "id": 1,
        "fileName": "MEDEN_File_1",
        "parentFolderid": 3
    },
    {
        "id": 2,
        "fileName": "MEDEN_File_1",
        "parentFolderid": 3
    }
]



  downloadFolder(folderId: string): void {
    // Implement your download logic using the folderId
    console.log(`Downloading folder with id: ${folderId}`);
    // Add your download logic here
  }


  toggleSubfolders(folderId: string): void {
    // Implement your toggle subfolders logic using the folderId
    console.log(`Toggling subfolders for folder with id: ${folderId}`);
    // Add your toggle subfolders logic here
  }
}
