import { Component } from '@angular/core';
import { initializeApp } from 'firebase/app';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'rick-and-morty-app';

  firebaseConfig = {
    apiKey: "AIzaSyBiUpdBNr4hjAjubWdO5LCLj2mmkKgselU",
    authDomain: "gassapp-535fc.firebaseapp.com",
    projectId: "gassapp-535fc",
    storageBucket: "gassapp-535fc.firebasestorage.app",
    messagingSenderId: "143340053622",
    appId: "1:143340053622:web:bb3cff0b01f48c559eab57"
  };

  app = initializeApp(this.firebaseConfig);
}
