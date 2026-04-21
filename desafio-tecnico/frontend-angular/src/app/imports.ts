import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { DialogModule } from 'primeng/dialog';
import { InputTextModule } from 'primeng/inputtext';
import { RadioButtonModule } from 'primeng/radiobutton';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    TableModule,
    ToastModule,
    ButtonModule,
    DialogModule,
    InputTextModule,
    RadioButtonModule
  ],
  exports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    TableModule,
    ToastModule,
    ButtonModule,
    DialogModule,
    InputTextModule,
    RadioButtonModule
  ]
})
export class ImportsModule {
}
