import { Component, OnInit } from '@angular/core';
import { PostesService } from './postes.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-postes',
  templateUrl: './postes.component.html',
  styleUrls: ['./postes.component.css']
})
export class PostesComponent implements OnInit {
  public postes: any[] = []; // Initialize postes array

  constructor(private posteService:  PostesService) {
  }



  ngOnInit(): void {
    this.loadPostes();
  }

  loadPostes(): void {
    this.posteService.getAllPostes()
      .subscribe(
        (data: any[]) => { // Specify type for data parameter
          this.postes = data;
        },
        (error: any) => { // Specify type for error parameter
          console.log('Error fetching postes:', error);
        }
      );
  }

  deletePoste(id: string): void {
//     const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
//       width: '250px',
//       data: 'Are you sure you want to delete this post?'
//     });
//
//     dialogRef.afterClosed().subscribe(result => {
//       if (result) {
//         this.posteService.deletePoste(id)
//           .subscribe(
//             () => {
              console.log('Poste deleted successfully.');
              // Reload postes after deletion
              this.loadPostes();
//             },
//             (error: any) => {
//               console.log('Error deleting poste:', error);
//             }
//           );
//       } });
  }

//   addPoste(): void {
//     const newPoste: any = {
//       // Define properties for the new poste
//     };
//
//     this.posteService.createPoste(newPoste)
//       .subscribe(
//         () => {
//           console.log('Poste added successfully.');
//           // Reload postes after addition
//           this.loadPostes();
//         },
//         error => {
//           console.log('Error adding poste:', error);
//         }
//       );






