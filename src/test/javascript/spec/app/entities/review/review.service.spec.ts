import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { ReviewService } from 'app/entities/review/review.service';
import { IReview, Review } from 'app/shared/model/review.model';

describe('Service Tests', () => {
  describe('Review Service', () => {
    let injector: TestBed;
    let service: ReviewService;
    let httpMock: HttpTestingController;
    let elemDefault: IReview;
    let expectedResult: IReview | IReview[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(ReviewService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new Review(0, currentDate, 'AAAAAAA', 'AAAAAAA', 0);
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign(
          {
            timeStamp: currentDate.format(DATE_TIME_FORMAT),
          },
          elemDefault
        );

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a Review', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            timeStamp: currentDate.format(DATE_TIME_FORMAT),
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            timeStamp: currentDate,
          },
          returnedFromService
        );

        service.create(new Review()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a Review', () => {
        const returnedFromService = Object.assign(
          {
            timeStamp: currentDate.format(DATE_TIME_FORMAT),
            message: 'BBBBBB',
            user: 'BBBBBB',
            rating: 1,
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            timeStamp: currentDate,
          },
          returnedFromService
        );

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of Review', () => {
        const returnedFromService = Object.assign(
          {
            timeStamp: currentDate.format(DATE_TIME_FORMAT),
            message: 'BBBBBB',
            user: 'BBBBBB',
            rating: 1,
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            timeStamp: currentDate,
          },
          returnedFromService
        );

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a Review', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});