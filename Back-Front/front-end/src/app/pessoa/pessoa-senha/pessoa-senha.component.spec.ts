import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PessoaSenhaComponent } from './pessoa-senha.component';

describe('PessoaSenhaComponent', () => {
  let component: PessoaSenhaComponent;
  let fixture: ComponentFixture<PessoaSenhaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PessoaSenhaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PessoaSenhaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
