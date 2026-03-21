import { FishingInstructor } from './fishing-insructor';
import { AvailabilityPeriod } from "./availability-period";
import { Reservation } from "./reservation";

export interface Adventure{

    id?: number;
    name: string;
    address: string;
    city: string;
    description: string;
    pricePerDay: any;
    avgGrade: any;
    reservations?: Reservation[];
    availablePeriods?: AvailabilityPeriod[];
    rules?: string[];
    additionalServices: string;
    cancellationCondition: string;
    instructor: FishingInstructor;
    maxNumPeople: number;
    fishing_equipment: string [];
    imageUrls: string [];

}