import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { LottieComponent, LottieDirective, provideLottieOptions } from 'ngx-lottie';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PokemonBattleComponent } from './components/pokemon-battle/pokemon-battle.component';
import { PokemonComponent } from './components/pokemon/pokemon.component';
import { provideHttpClient } from '@angular/common/http';
import { PokemonListComponent } from './components/pokemon-list/pokemon-list.component';
import { PokemonImgPipe } from './pipes/pokemon-img.pipe';

@NgModule({
  declarations: [
    AppComponent,
    PokemonBattleComponent,
    PokemonComponent,
    PokemonListComponent,
    PokemonImgPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    LottieComponent,
    LottieDirective
  ],
  providers: [
    provideClientHydration(),
    provideHttpClient(),
    provideLottieOptions({
      player: () => import('lottie-web')
    })
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
