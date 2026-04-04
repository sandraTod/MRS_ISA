export interface ReservationRequest {

     resourceId: number;
     startDate: string;
     endDate: string;
     numOfPeople: number;
     maxNumPeople: number;
     selectedServices: string[];
}