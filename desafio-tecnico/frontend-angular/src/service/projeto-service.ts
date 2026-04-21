import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cidade } from '@domain/cidade';
import { CityDTO } from '@domain/city-dto';
import { Observable } from 'rxjs';
import { environment } from '../app/environments/environment';

@Injectable()
export class ProjetoService {

  constructor(private http: HttpClient) {}

  //------------------------------------------------
  /** Recupera a lista de cidades */
  //------------------------------------------------
  pesquisarCidades(): Observable<CityDTO[]> {
    return this.http.get<CityDTO[]>(`${environment.apiUrl}${environment.urlCidades}`);
  }

  //------------------------------------------------
  /** Exclui a cidade informada */
  //------------------------------------------------
  excluir(cidade: Cidade): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}${environment.urlCidades}/${cidade.id}`);
  }

  //------------------------------------------------
  /** Salva a cidade informada */
  //------------------------------------------------
  salvar(cidade: Cidade): Observable<void> {
    const dto: CityDTO = {
      id: cidade.id,
      nome: cidade.nome,
      uf: cidade.uf,
      capital: cidade.capital
    };

    if (cidade.id) {
      return this.http.put<void>(`${environment.apiUrl}${environment.urlCidades}`, dto);
    }

    return this.http.post<void>(`${environment.apiUrl}${environment.urlCidades}`, dto);
  }

}
