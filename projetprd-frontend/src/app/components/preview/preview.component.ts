import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FolderService } from 'src/app/services/folder.service';
// import { NavbarModule, WavesModule, ButtonsModule } from 'angular-bootstrap-md'
@Component({
  selector: 'app-preview',
  templateUrl: './preview.component.html',
  styleUrls: ['./preview.component.css']
})
export class PreviewComponent {
  [x: string]: any;


  folders: any[] = [];
  folderId: number =1;

constructor( private folderService: FolderService,
  private route: ActivatedRoute,
  private router :Router) {}

ngOnInit(): void {
  this.route.params.subscribe(params => {
    this.folderId = params['id'];
    console.log("id === ",this.folderId);
    this.loadFolders(this.folderId);
  });
}

loadFolders(id:number): void {
  
  this.folderService.getFolders(id).subscribe(
    (data) => {
      this.folders = data;
      
    },
    (error) => {
      console.error('Error fetching folders from the backend:', error);
    }
  );
}



  downloadFolder(folderId: string): void {
    // Implement your download logic using the folderId
    console.log(`Downloading folder with id: ${folderId}`);
    // Add your download logic here
  }


  toggleSubfolders(folderId: string): void {
    this.router.navigate(['/preview', folderId]);
  }

  isFolder(item: any): boolean {
    return item.folder;
  }
}
