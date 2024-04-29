import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PostesComponent} from "./ui/postes/postes.component";


const routes: Routes = [
  {path : "postes", component : PostesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
