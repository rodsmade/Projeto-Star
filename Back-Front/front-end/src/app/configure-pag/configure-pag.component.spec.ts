import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfigurePagComponent } from './configure-pag.component';

describe('ConfigurePagComponent', () => {
  let component: ConfigurePagComponent;
  let fixture: ComponentFixture<ConfigurePagComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConfigurePagComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfigurePagComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
