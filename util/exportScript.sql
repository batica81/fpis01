drop table if exists ARTIKAL;
drop table if exists Ponuda;
drop table if exists StavkaPonude;
create table ARTIKAL (SIFRAARTIKLA integer not null, JEDINICAMERE varchar(255), NAZIVARTIKLA varchar(255), OPISARTIKLA varchar(255), primary key (SIFRAARTIKLA));
create table Ponuda (BrPonude integer not null, Banka varchar(255), Datum datetime, DatumPrometa varchar(255), Isporuka varchar(255), Mesto varchar(255), Napomena varchar(255), PozivNaBroj varchar(255), SifraKupca integer, SifraRadnika integer, TekuciRacun varchar(255), TipPlacanja varchar(255), Uslovi varchar(255), Validnost varchar(255), primary key (BrPonude));
create table StavkaPonude (Rbr integer not null, BrPonude integer not null, Kolicina integer, SifraArtikla integer not null, primary key (Rbr, BrPonude));
alter table StavkaPonude add constraint FKg2r7mhbb0pcg3ko84eepxdo32 foreign key (SifraArtikla) references ARTIKAL (SIFRAARTIKLA);
alter table StavkaPonude add constraint FKha8qo9fq6hx3xp7eui4klw94h foreign key (BrPonude) references Ponuda (BrPonude);
