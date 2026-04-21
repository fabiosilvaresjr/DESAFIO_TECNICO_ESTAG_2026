export interface CommerceDTO {
  id?: number;
  nomeComercio: string;
  nomeResponsavel: string;
  tipoComercio: 'FARMACIA' | 'PADARIA' | 'POSTO_GASOLINA' | 'LANCHONETE';
  cidadeId: number;
}
