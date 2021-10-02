import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class Ticket {
    private static final DeviceRgb COLOR_FOR_TABLE_BACKGROUND = new DeviceRgb(252, 252, 252);
    private static final DeviceRgb Background_Color_For_toAndFromTable = new DeviceRgb(0, 24, 84);


    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
        String path = "P:\\Java\\My pdf\\MainPdf.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument, PageSize.A4);
        pdfDocument.addNewPage();

        float[] headerWidth = {200, 210, 120};
        String PhoneNumber = "9557373673";
        Table header = AddHeader(headerWidth, PhoneNumber);

        float[] IdTableWidth = {180, 180, 180};
        String PNR = "95291", TicketId = "TS210814155304275567CKMA", OrderId="14703033303";
        Table IdTable = AddIDTable(IdTableWidth,PNR, TicketId, OrderId);


        float[] toAndFromTableWidth = {100,340,100};
        String DeparturePlace = "Delhi", DepartureTime = "9:15 PM", DepartureDate= "Sat, 14 Aug 2021";
        String ArrivalPlace = "Haldwani", ArrivalTime = "5:15 AM", ArrivalDate = "Sun, 15 Aug 2021";

        Table toAndFromTable = AddtoAndFromTable(toAndFromTableWidth, DeparturePlace, DepartureTime,DepartureDate, ArrivalPlace,ArrivalTime, ArrivalDate);

        float[] boardingDetails1Width = {30, 510};
        String busOperatorName1 = "International Tourist Center Haldwani To Nainital Drop By",
                busOperatorName2 = "T 2+1, CABIN SLEEPER/SEATER, AC",
                boardingPoint1 = "Kashimiri Gate (Pickup Van/Bus) ",
                boardingPoint2 = "Kashmiri Gate Metro Station Metro Gate No.4 Near Metro Gate No.4,Near Bharat Petrol Pump",
                droppingPoint1 = "Haldwani (Pickup Van/Bus) ",
                droppingPoint2 = "Near Bus Stand OK Hotel Saras Market",
                reportingTime = "9:00 PM",
                BoardingTime = "9:15 PM",
                OperatorContactNumber= "9212702222 9312493124 0120-4327298",
                Landmark = "Near Metro Gate No.4,Near Bharat Petrol Pump";


        Table boardingDetails1 = AddBoardingDetails1(boardingDetails1Width, busOperatorName1,busOperatorName2, boardingPoint1,boardingPoint2, droppingPoint1, droppingPoint2);
        float[] boardingDetails2Width = {30,150, 30,330};
        Table boardingDetails2 = AddBoardingDetails2(boardingDetails2Width, reportingTime, BoardingTime);

        Table boardingDetails3 = AddBoardingDetails3(boardingDetails1Width, OperatorContactNumber, Landmark);

        String TravellerName = "Aman Sharma", TravellerGender = "Male", TravellerSeatNo = "SU3";
        Table travellerDetailsHeadder = AddHeadder("TRAVELLER DETAILS", false);
        float[] travellerDetailsWidth= {30, 210,170,130};
        Table travellerDetails = AddtravellerDetails(travellerDetailsWidth, TravellerName, TravellerGender, TravellerSeatNo);


        Table FareHeadder = AddHeadder("FARE & PAYMENT DETAILS", true);
        float[] FareAndPaymentDetailsWidth = {400,50, 90};
        String BaseFare = "₹ 799", DealDiscount = "₹ 39", OperatorGST = "₹ 38", Total = "₹ 798";
        Table FareAndPaymentDetails = AddFareAndPaymentDetails(FareAndPaymentDetailsWidth, BaseFare,DealDiscount, OperatorGST, Total);

        float[] DiscountDetailsWidth = {530, 10};
        String Discount = "'Instant Discount worth 39 has been applied on your booking.'";
        Table DiscountDetails = AddDiscountDetails(DiscountDetailsWidth, Discount);

        float[] CancellationPolicyWidth = {540};
        String Policy = "a. Refund policy mentioned above is indicative. The actual cancellation charges are determined by bus operators and bus providers at the actual time of cancellation. Paytm has no role in\n" +
                "governing cancellation charges.\n" +
                "b. Cancellation charges are calculated on the actual fare of the ticket, if any discount coupons are used while purchasing the ticket, the discounted value would be used to calculate the refund\n" +
                "amount when a ticket is cancelled.\n" +
                "c. Partial cancellation of tickets in the same order is not allowed\n";


        Table CancellationPolicy = AddCancellationPolicy(CancellationPolicyWidth, Policy);

        String forBefore72Hr = "100%", For24To72Hr = "50%",
                For12To24Hr= "0%",For0To12Hr="0%";


        float[] RefundPolicyWidth = {35,235,235,35};
        Table RefundPolicy = AddRefundPolicy(RefundPolicyWidth, forBefore72Hr,For24To72Hr, For12To24Hr, For0To12Hr);

        float[] MarginTableWidth = {30,510};
        Table MarginTable = new Table(MarginTableWidth);
        AddTableMargin(MarginTable, 5, new DeviceRgb(255,255,255));

        float[] TermsAndConditionWidth = {540};
        String TermsAndConditions = "a. Rts is only a bus ticket booking platform. It does not operate bus services of its own. " +
                "In order to provide a comprehensive choice of bus operators, departure times and prices to customers, it has tied up with many bus operators and service providers. Paytms network of bus operators.\n" +
                "b. Providing refund and support in the event of cancellation.\n" +
                "c. Providing customer support and information in case of any delays / inconvenience.";

        Table TermsAndCond = AddTermsAndConditions(TermsAndConditionWidth, TermsAndConditions);

        float[] ExtrasWidth = {540};
        String Extras = "a. The bus operators expectation.\n" +
                "b. The bus operator canceling the trip due to unavoidable reasons.\n" +
                "c. The baggage of the customer getting lost / stolen / damaged.\n" +
                "d. The bus operator changing a customer's seat at the last minute to accommodate a lady / child.";

        Table ExtraTable = AddExtra(ExtrasWidth, Extras);

        document.add(header);
        document.add(IdTable);
        document.add(toAndFromTable);
        document.add(boardingDetails1);
        document.add(boardingDetails2);
        document.add(boardingDetails3);
        document.add(travellerDetailsHeadder);
        document.add(travellerDetails);
        document.add(FareHeadder);
        document.add(FareAndPaymentDetails);
        document.add(DiscountDetails);
        document.add(CancellationPolicy);
        document.add(RefundPolicy);
        document.add(MarginTable);
        document.add(TermsAndCond);
        document.add(ExtraTable);

        document.close();

        System.out.println("Pdf Created!!!");

    }

    private static Table AddExtra(float[] extrasWidth, String extras) {
        Table table = new Table(extrasWidth);
        Paragraph p = new Paragraph();
        p.add(new Text("Rts is not responsible for:\n")
                .setTextAlignment(TextAlignment.LEFT)
                .setFontSize(11)
                .setFontColor(new DeviceRgb(0,0,0))
                .setCharacterSpacing(1));

        p.add(extras)
                .setTextAlignment(TextAlignment.LEFT)
                .setFontSize(10)
                .setFontColor(new DeviceRgb(80,80,80));
        p.add("\n");
        table.addCell(new Cell().add(p)
                .setPaddingLeft(20)
                .setTextAlignment(TextAlignment.LEFT)
                .setPaddingRight(20)
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderTop(Border.NO_BORDER)
        );

        return table;
    }

    private static Table AddTermsAndConditions(float[] termsAndConditionWidth, String termsAndConditions) {
        Table table = new Table(termsAndConditionWidth);
        Paragraph p = new Paragraph();
        p.add(new Text("Terms And Conditions:\n")
                .setTextAlignment(TextAlignment.LEFT)
                .setFontSize(11)
                .setFontColor(new DeviceRgb(0,0,0))
                .setCharacterSpacing(1));

        p.add(termsAndConditions)
                .setTextAlignment(TextAlignment.LEFT)
                .setFontSize(10)
                .setFontColor(new DeviceRgb(80,80,80));
        p.add("\n\n");
        table.addCell(new Cell().add(p)
                .setPaddingLeft(20)
                .setTextAlignment(TextAlignment.LEFT)
                .setPaddingRight(20)
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );
        return table;

    }

    private static Table AddRefundPolicy(float[] refundPolicyWidth, String forBefore72Hr, String for24To72Hr, String for12To24Hr, String for0To12Hr) {
        Table table = new Table(refundPolicyWidth);


        table.addCell(new Cell().add(new Paragraph(""))
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
        );
        table.addCell(new Cell().add(new Paragraph("Hours before Departure"))
                .setBold()
                .setCharacterSpacing(1)
                .setFontSize(9.5F)
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setBorderRight(Border.NO_BORDER)
                .setMarginLeft(20)
                .setPadding(10)
        );

        table.addCell(new Cell().add(new Paragraph("Refund Percentage"))
                .setBold()
                .setCharacterSpacing(1)
                .setFontSize(9.5F)
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setBorderLeft(Border.NO_BORDER)
                .setMarginRight(10)
                .setPadding(10)

        );

        table.addCell(new Cell().add(new Paragraph(""))
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
        );

        table.addCell(new Cell().add(new Paragraph(""))
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
        );
        table.addCell(new Cell().add(new Paragraph("Before 72 Hrs."))
                .setCharacterSpacing(1)
                .setFontSize(9.5F)
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginLeft(20)
                .setPadding(10)
                .setFontColor(new DeviceRgb(140,140,140))
        );

        table.addCell(new Cell().add(new Paragraph(forBefore72Hr))
                .setCharacterSpacing(1)
                .setFontSize(9.5F)
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginRight(10)
                .setPadding(10)
                .setFontColor(new DeviceRgb(140,140,140))

        );

        table.addCell(new Cell().add(new Paragraph(""))
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
        );

        table.addCell(new Cell().add(new Paragraph(""))
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
        );
        table.addCell(new Cell().add(new Paragraph("Between 24 Hrs. to 72 Hrs."))
                .setCharacterSpacing(1)
                .setFontSize(8F)
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginLeft(20)
                .setPadding(10)
                .setFontColor(new DeviceRgb(140,140,140))
        );

        table.addCell(new Cell().add(new Paragraph(for24To72Hr))
                .setCharacterSpacing(1)
                .setFontSize(9.5F)
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginRight(10)
                .setPadding(10)
                .setFontColor(new DeviceRgb(140,140,140))

        );

        table.addCell(new Cell().add(new Paragraph(""))
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
        );

        table.addCell(new Cell().add(new Paragraph(""))
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
        );
        table.addCell(new Cell().add(new Paragraph("Between 12 Hrs. to 24 Hrs."))
                .setCharacterSpacing(1)
                .setFontSize(9.5F)
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginLeft(20)
                .setPadding(10)
                .setFontColor(new DeviceRgb(140,140,140))
        );

        table.addCell(new Cell().add(new Paragraph(for12To24Hr))
                .setCharacterSpacing(1)
                .setFontSize(9.5F)
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginRight(10)
                .setPadding(10)
                .setFontColor(new DeviceRgb(140,140,140))

        );

        table.addCell(new Cell().add(new Paragraph(""))
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
        );

        table.addCell(new Cell().add(new Paragraph(""))
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)

        );
        table.addCell(new Cell().add(new Paragraph("Between 0 Hrs. to 12 Hrs."))
                .setCharacterSpacing(1)
                .setFontSize(9.5F)
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginLeft(20)
                .setPadding(10)
                .setFontColor(new DeviceRgb(140,140,140))
        );

        table.addCell(new Cell().add(new Paragraph(for0To12Hr))
                .setCharacterSpacing(1)
                .setFontSize(9.5F)
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginRight(10)
                .setPadding(10)
                .setFontColor(new DeviceRgb(140,140,140))

        );

        table.addCell(new Cell().add(new Paragraph(""))
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
        );
        return table;
    }

    private static Table AddCancellationPolicy(float[] cancellationPolicyWidth, String policy) {
        Table table = new Table(cancellationPolicyWidth);
        Paragraph p = new Paragraph();
        p.add(new Text("Cancellation Policy:\n")
                .setTextAlignment(TextAlignment.LEFT)
                .setFontSize(11)
                .setFontColor(new DeviceRgb(0,0,0))
                .setCharacterSpacing(1));

        p.add(policy)
                .setTextAlignment(TextAlignment.LEFT)
                .setFontSize(10)
                .setFontColor(new DeviceRgb(80,80,80));
        p.add("\n\n");
        table.addCell(new Cell().add(p)
                .setPaddingLeft(20)
                .setTextAlignment(TextAlignment.LEFT)
                .setPaddingRight(20)
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );


        return  table;
    }


    private static Table AddDiscountDetails(float[] discountDetailsWidth, String discount) {
        Table table = new Table(discountDetailsWidth);
        AddTableMargin(table,1,new DeviceRgb(255,255,255));
        table.addCell(new Cell().add(new Paragraph(discount))
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setFontSize(10)
                .setCharacterSpacing(1.3F)
                .setPaddingLeft(35)
        );

        table.addCell(new Cell().add(new Paragraph(""))
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
                .setFontSize(10)

        );

        AddTableMargin(table,3,new DeviceRgb(255,255,255));
        return table;
    }

    private static Table AddFareAndPaymentDetails(float[] fareAndPaymentDetailsWidth, String baseFare, String dealDiscount, String operatorGST, String total) throws MalformedURLException {
        Table table = new Table(fareAndPaymentDetailsWidth);


        table.addCell(new Cell().add(new Paragraph("Base Fare (1 Traveller):"))
                .setCharacterSpacing(1F)
                .setPaddingLeft(40)
                .setFontSize(9)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setFontColor(new DeviceRgb(60, 60, 60))
        );
        table.addCell(new Cell().add(new Image(ImageDataFactory.create("P:\\Java\\pdf\\src\\main\\java\\rupee-icon.png")).scaleAbsolute(10,10))
                .setTextAlignment(TextAlignment.RIGHT)
                .setBorder(Border.NO_BORDER)
                .setPaddingLeft(50)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
        );

        table.addCell(new Cell().add(new Paragraph(baseFare))
                .setFontSize(10)
                .setTextAlignment(TextAlignment.LEFT)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
        );

        table.addCell(new Cell().add(new Paragraph("Deal Discount :"))
                .setCharacterSpacing(1F)
                .setPaddingLeft(40)
                .setFontSize(9)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setFontColor(new DeviceRgb(60, 60, 60))
        );

        Paragraph p = new Paragraph();
        Image img = new Image(ImageDataFactory.create("P:\\Java\\pdf\\src\\main\\java\\rupee-icon.png")).scaleAbsolute(10,10);
        p.add("- ");
        p.add(img);

        table.addCell(new Cell().add(p)
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.RIGHT)
        );

        table.addCell(new Cell().add(new Paragraph(dealDiscount))
                .setFontSize(10)
                .setTextAlignment(TextAlignment.LEFT)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
        );

        table.addCell(new Cell().add(new Paragraph("Operator GST :"))
                .setCharacterSpacing(1F)
                .setPaddingLeft(40)
                .setFontSize(9)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setFontColor(new DeviceRgb(60, 60, 60))
        );
        table.addCell(new Cell().add(new Image(ImageDataFactory.create("P:\\Java\\pdf\\src\\main\\java\\rupee-icon.png")).scaleAbsolute(10,10))
                .setTextAlignment(TextAlignment.RIGHT)
                .setBorder(Border.NO_BORDER)
                .setPaddingLeft(50)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
        );

        table.addCell(new Cell().add(new Paragraph(operatorGST))
                .setFontSize(10)
                .setTextAlignment(TextAlignment.LEFT)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
        );

        table.addCell(new Cell().add(new Paragraph("Total Amount Paid :"))
                .setCharacterSpacing(1F)
                .setPaddingLeft(40)
                .setFontSize(9)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setFontColor(new DeviceRgb(60, 60, 60))
        );
        table.addCell(new Cell().add(new Image(ImageDataFactory.create("P:\\Java\\pdf\\src\\main\\java\\rupee-icon.png")).scaleAbsolute(10,10))
                .setTextAlignment(TextAlignment.RIGHT)
                .setBorder(Border.NO_BORDER)
                .setPaddingLeft(50)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
        );

        table.addCell(new Cell().add(new Paragraph(total))
                .setFontSize(10)
                .setTextAlignment(TextAlignment.LEFT)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
        );



        return  table;
    }

    private static Table AddtravellerDetails(float[] travellerDetailsWidth, String travellerName, String travellerGender, String travellerSeatNo) throws MalformedURLException {
        Table table = new Table(travellerDetailsWidth);

        table.addCell(new Cell().add(new Paragraph(""))
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );
        table.addCell(new Cell().add(new Paragraph("Name"))
                .setTextAlignment(TextAlignment.LEFT)
                .setFontColor(new DeviceRgb(107, 107, 107))
                .setFontSize(10)
                .setBorder(Border.NO_BORDER)
        );
        table.addCell(new Cell().add(new Paragraph("Gender"))
                .setTextAlignment(TextAlignment.LEFT)
                .setFontColor(new DeviceRgb(107, 107, 107))
                .setFontSize(10)
                .setBorder(Border.NO_BORDER)
        );
        table.addCell(new Cell().add(new Paragraph("Seat No."))
                .setTextAlignment(TextAlignment.LEFT)
                .setFontColor(new DeviceRgb(107, 107, 107))
                .setFontSize(10)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
        );
        table.addCell(new Cell().add(new Image(ImageDataFactory.create("P:\\Java\\pdf\\src\\main\\java\\Circle-icon.png")).scaleAbsolute(10,10))
                .setTextAlignment(TextAlignment.RIGHT)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setPaddingLeft(15)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setStrokeColor(new DeviceRgb(107, 107, 107))
                .setBackgroundColor(new DeviceRgb(255,255,255))
        );
        table.addCell(new Cell().add(new Paragraph(travellerName))
                .setBackgroundColor(new DeviceRgb(255,255,255))
                .setBorder(Border.NO_BORDER)
                .setFontColor(new DeviceRgb(36, 36, 36))
                .setCharacterSpacing(0.5F)
                .setFontSize(10)
        );
        table.addCell(new Cell().add(new Paragraph(travellerGender))
                .setBackgroundColor(new DeviceRgb(255,255,255))
                .setBorder(Border.NO_BORDER)
                .setFontColor(new DeviceRgb(36, 36, 36))
                .setCharacterSpacing(0.5F)
                .setFontSize(10)
        );
        table.addCell(new Cell().add(new Paragraph(travellerSeatNo))
                .setBackgroundColor(new DeviceRgb(255,255,255))
                .setBorderTop(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setFontColor(new DeviceRgb(36, 36, 36))
                .setCharacterSpacing(0.5F)
                .setFontSize(10)
        );


        return table;
    }

    private static Table AddBoardingDetails1(float[] boardingDetailsWidth, String busOperatorName1,String busOperatorName2, String boardingPoint1,String boardingPoint2,  String droppingPoint1, String droppingPoint2) throws MalformedURLException {
        Table table = new Table(boardingDetailsWidth);

        Paragraph paragraph1 = new Paragraph();

        paragraph1.add(new Text(busOperatorName1)
                .setFontColor(new DeviceRgb(36, 36, 36))
                .setCharacterSpacing(1.1F)
                .setFontSize(10)
        );

        paragraph1.add(new Text("\n"+busOperatorName2)
                .setCharacterSpacing(1)
                .setFontSize(8.9F)
                .setFontColor(new DeviceRgb(107, 107, 107))
        );

        Paragraph paragraph2 = new Paragraph();
        paragraph2.add(new Text(boardingPoint1)
                .setFontColor(new DeviceRgb(36, 36, 36))
                .setCharacterSpacing(1.1F)
                .setFontSize(10)
        );

        paragraph2.add(new Text("\n"+boardingPoint2)
                .setCharacterSpacing(1)
                .setFontSize(8.9F)
                .setFontColor(new DeviceRgb(107, 107, 107))
        );


        Paragraph paragraph3 = new Paragraph();
        paragraph3.add(new Text(droppingPoint1)
                .setFontColor(new DeviceRgb(36, 36, 36))
                .setCharacterSpacing(1.1F)
                .setFontSize(10)
        );

        paragraph3.add(new Text("\n"+droppingPoint2)
                .setCharacterSpacing(1)
                .setFontSize(8.9F)
                .setFontColor(new DeviceRgb(107, 107, 107))
        );

        AddTableMargin(table, 6, COLOR_FOR_TABLE_BACKGROUND);

        table.addCell(new Cell().add(new Image(ImageDataFactory.create("P:\\Java\\pdf\\src\\main\\java\\bus-icon.png")).scaleAbsolute(12,12))
                .setTextAlignment(TextAlignment.RIGHT)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setPaddingLeft(15)
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
        );

        table.addCell(new Cell().add(new Paragraph("Bus Operator Name"))
                .setFontColor(new DeviceRgb(6, 106, 199))
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setMarginLeft(8)
                .setFontSize(11.5F)
        );

        table.addCell(new Cell().add(new Paragraph(""))
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderTop(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );

        table.addCell(new Cell().add(paragraph1)
                .setBorderLeft(Border.NO_BORDER)
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );

        AddTableMargin(table, 6, COLOR_FOR_TABLE_BACKGROUND);

        table.addCell(new Cell().add(new Image(ImageDataFactory.create("P:\\Java\\pdf\\src\\main\\java\\location-icon.png")).scaleAbsolute(12,12))
                .setTextAlignment(TextAlignment.RIGHT)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setPaddingLeft(15)
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
        );

        table.addCell(new Cell().add(new Paragraph("Boarding Point"))
                .setFontColor(new DeviceRgb(6, 106, 199))
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setMarginLeft(8)
                .setFontSize(11.5F)
        );

        table.addCell(new Cell().add(new Paragraph(""))
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderTop(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );

        table.addCell(new Cell().add(paragraph2)
                .setBorderLeft(Border.NO_BORDER)
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );

        AddTableMargin(table, 6, COLOR_FOR_TABLE_BACKGROUND);

        table.addCell(new Cell().add(new Image(ImageDataFactory.create("P:\\Java\\pdf\\src\\main\\java\\location-icon.png")).scaleAbsolute(12,12))
                .setTextAlignment(TextAlignment.RIGHT)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setPaddingLeft(15)
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
        );

        table.addCell(new Cell().add(new Paragraph("Dropping Point"))
                .setFontColor(new DeviceRgb(6, 106, 199))
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setMarginLeft(8)
                .setFontSize(11.5F)
        );

        table.addCell(new Cell().add(new Paragraph(""))
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderTop(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );

        table.addCell(new Cell().add(paragraph3)
                .setBorderLeft(Border.NO_BORDER)
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );

        AddTableMargin(table, 6, COLOR_FOR_TABLE_BACKGROUND);
        return  table;
    }

    private static Table AddBoardingDetails2(float[] boardingDetails2Width, String reportingTime, String BoardingTime) throws MalformedURLException {
        Table table = new Table(boardingDetails2Width);

        table.addCell(new Cell().add(new Image(ImageDataFactory.create("P:\\Java\\pdf\\src\\main\\java\\clock-icon.png")).scaleAbsolute(12,12))
                .setTextAlignment(TextAlignment.RIGHT)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setPaddingLeft(15)
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
        );

        table.addCell(new Cell().add(new Paragraph("Reporting Time"))
                .setFontColor(new DeviceRgb(6, 106, 199))
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setMarginLeft(8)
                .setFontSize(11.5F)
                .setBorderRight(Border.NO_BORDER)
        );
        table.addCell(new Cell().add(new Image(ImageDataFactory.create("P:\\Java\\pdf\\src\\main\\java\\clock-icon.png")).scaleAbsolute(12,12))
                .setTextAlignment(TextAlignment.RIGHT)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setPaddingLeft(15)
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderLeft(Border.NO_BORDER)
        );
        table.addCell(new Cell().add(new Paragraph("Boarding Time"))
                .setFontColor(new DeviceRgb(6, 106, 199))
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setMarginLeft(8)
                .setFontSize(11.5F)
        );

        table.addCell(new Cell().add(new Paragraph(""))
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );

        table.addCell(new Cell().add(new Paragraph(reportingTime))
                .setFontColor(new DeviceRgb(36, 36, 36))
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
                .setFontSize(10)
        );
        table.addCell(new Cell().add(new Paragraph(""))
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
        );

        table.addCell(new Cell().add(new Paragraph(BoardingTime))
                .setFontColor(new DeviceRgb(36, 36, 36))
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
                .setFontSize(10)
        );


        return table;
    }

    private static Table AddBoardingDetails3(float[] boardingDetails1Width, String operatorContactNumber, String landmark) throws MalformedURLException {
        Table table = new Table(boardingDetails1Width);
        AddTableMargin(table, 6, COLOR_FOR_TABLE_BACKGROUND);

        Paragraph paragraph1 = new Paragraph();

        paragraph1.add(new Text(operatorContactNumber)
                .setFontColor(new DeviceRgb(36, 36, 36))
                .setCharacterSpacing(0.5F)
                .setFontSize(10)
        );

        Paragraph paragraph2 = new Paragraph();
        paragraph2.add(new Text(landmark)
                .setFontColor(new DeviceRgb(36, 36, 36))
                .setCharacterSpacing(1.1F)
                .setFontSize(10)
        );

        table.addCell(new Cell().add(new Image(ImageDataFactory.create("P:\\Java\\pdf\\src\\main\\java\\phoneIcon.png")).scaleAbsolute(15,15))
                .setTextAlignment(TextAlignment.RIGHT)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setPaddingLeft(15)
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
        );

        table.addCell(new Cell().add(new Paragraph("Operator Contact Number"))
                .setFontColor(new DeviceRgb(6, 106, 199))
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setMarginLeft(8)
                .setFontSize(11.5F)
        );

        table.addCell(new Cell().add(new Paragraph(""))
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderTop(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );

        table.addCell(new Cell().add(paragraph1)
                .setBorderLeft(Border.NO_BORDER)
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );

        AddTableMargin(table, 6, COLOR_FOR_TABLE_BACKGROUND);

        table.addCell(new Cell().add(new Image(ImageDataFactory.create("P:\\Java\\pdf\\src\\main\\java\\location-icon.png")).scaleAbsolute(15,15))
                .setTextAlignment(TextAlignment.RIGHT)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setPaddingLeft(15)
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
        );

        table.addCell(new Cell().add(new Paragraph("Landmark"))
                .setFontColor(new DeviceRgb(6, 106, 199))
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setMarginLeft(8)
                .setFontSize(11.5F)
        );

        table.addCell(new Cell().add(new Paragraph(""))
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderTop(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );

        table.addCell(new Cell().add(paragraph2)
                .setBorderLeft(Border.NO_BORDER)
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );

        AddTableMargin(table, 2, COLOR_FOR_TABLE_BACKGROUND);

        AddTableMargin(table, 2, new DeviceRgb(255,255,255));

        return table;
    }

    private static void AddTableMargin(Table table, int marginLength, DeviceRgb COLOR_FOR_TABLE) {



        for (int i=1; i<= marginLength; i++){
            table.addCell(new Cell().add(new Paragraph(""))
                    .setBorderBottom(Border.NO_BORDER)
                    .setBorderRight(Border.NO_BORDER)
                    .setBorderTop(Border.NO_BORDER)
                    .setBackgroundColor(COLOR_FOR_TABLE)
            );
            table.addCell(new Cell().add(new Paragraph(""))
                    .setBorderBottom(Border.NO_BORDER)
                    .setBorderLeft(Border.NO_BORDER)
                    .setBorderTop(Border.NO_BORDER)
                    .setBackgroundColor(COLOR_FOR_TABLE)
            );
        }

    }

    private static Table AddtoAndFromTable(float[]toAndFromTableWidth, String departurePlace, String departureTime, String departureDate, String arrivalPlace, String arrivalTime, String arrivalDate) throws MalformedURLException {
        Table table = new Table(toAndFromTableWidth);

        Paragraph paragraph1 = new Paragraph();

        paragraph1.add(new Text("Departure")
                .setFontColor(new DeviceRgb(0, 115, 255))
                .setFontSize(8)
                .setTextAlignment(TextAlignment.LEFT)
                .setCharacterSpacing(0.8F)
        );
        departurePlace = departurePlace.toUpperCase();
        paragraph1.add(new Text("\n"+ departurePlace)

                .setFontColor(new DeviceRgb(255,255,255))
                .setBold()
                .setTextAlignment(TextAlignment.LEFT)
                .setCharacterSpacing(2)

        );

        paragraph1.add(new Text("\n"+ departureTime)
                .setFontColor(new DeviceRgb(255,255,255))
                .setTextAlignment(TextAlignment.LEFT)
        );

        paragraph1.add(new Text("\n" + departureDate)
                .setFontColor(new DeviceRgb(209, 209, 209))
                .setTextAlignment(TextAlignment.LEFT)
                .setFontSize(8F)
        );

        table.addCell(new Cell().add(paragraph1)
                .setPadding(10)
                .setPaddingLeft(20)
                .setTextAlignment(TextAlignment.LEFT)
                .setBackgroundColor(Background_Color_For_toAndFromTable)
                .setBorderRight(Border.NO_BORDER)
                .setMarginTop(20)
        );


        table.addCell(new Cell().add(new Image(ImageDataFactory.create("P:\\Java\\pdf\\src\\main\\java\\bus.png")).scaleAbsolute(25f,25f))

                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setBorderRight(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
                        .setPaddingLeft(150)
                .setBackgroundColor(Background_Color_For_toAndFromTable)
                .setMarginTop(20)
        );


        Paragraph paragraph2 = new Paragraph();

        paragraph2.add(new Text("Arrival")
                .setFontColor(new DeviceRgb(0, 115, 255))
                .setFontSize(8)
                .setTextAlignment(TextAlignment.RIGHT)
                .setCharacterSpacing(0.8F)
        );
        arrivalPlace = arrivalPlace.toUpperCase();
        paragraph2.add(new Text("\n"+ arrivalPlace)

                .setFontColor(new DeviceRgb(255,255,255))
                .setBold()
                .setTextAlignment(TextAlignment.RIGHT)
                .setCharacterSpacing(2)

        );

        paragraph2.add(new Text("\n"+ arrivalTime)
                .setFontColor(new DeviceRgb(255,255,255))
                .setTextAlignment(TextAlignment.RIGHT)
        );

        paragraph2.add(new Text("\n" + arrivalDate)
                .setFontColor(new DeviceRgb(209, 209, 209))
                .setTextAlignment(TextAlignment.RIGHT)
                .setFontSize(8F)
        );

        table.addCell(new Cell().add(paragraph2)
                .setPadding(10)
                .setPaddingRight(20)
                .setTextAlignment(TextAlignment.RIGHT)
                .setBackgroundColor(Background_Color_For_toAndFromTable)
                .setBorderLeft(Border.NO_BORDER)
                .setMarginTop(20)
        );

        return table;
    }

    private static Table AddIDTable(float[] idTableWidth,String Pnr, String TicketId, String OrderId) {
        Table IdTable = new Table(idTableWidth);

        IdTable.addCell(new Cell().add(new Paragraph("PNR"))
                .setTextAlignment(TextAlignment.CENTER)
                .setBorderBottom(Border.NO_BORDER)
                .setPadding(10)
                .setFontSize(7)
                .setFontColor(new DeviceRgb(107, 107, 107))
                .setHeight(10)
        );


        IdTable.addCell(new Cell().add(new Paragraph("Ticket ID"))
                .setTextAlignment(TextAlignment.CENTER)
                .setBorderBottom(Border.NO_BORDER)
                .setPadding(10)
                .setFontSize(7)
                .setFontColor(new DeviceRgb(107, 107, 107))
                .setHeight(10)
        );

        IdTable.addCell(new Cell().add(new Paragraph("Order Id"))
                .setTextAlignment(TextAlignment.CENTER)
                .setBorderBottom(Border.NO_BORDER)
                .setPadding(10)
                .setFontSize(7)
                .setFontColor(new DeviceRgb(107, 107, 107))
                .setHeight(10)


        );

        IdTable.addCell(new Cell().add(new Paragraph(Pnr))
                .setStrokeWidth(2)
                .setFontSize(8.8F)
                .setTextAlignment(TextAlignment.CENTER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setCharacterSpacing(0.5F)
                .setVerticalAlignment(VerticalAlignment.TOP)
        );
        IdTable.addCell(new Cell().add(new Paragraph(TicketId))
                .setStrokeWidth(2)
                .setFontSize(8.8F)
                .setTextAlignment(TextAlignment.CENTER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setCharacterSpacing(0.5F)
                .setVerticalAlignment(VerticalAlignment.TOP)
        );
        IdTable.addCell(new Cell().add(new Paragraph(OrderId))
                .setStrokeWidth(2)
                .setFontSize(8.8F)
                .setTextAlignment(TextAlignment.CENTER)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setCharacterSpacing(0.5F)
                .setVerticalAlignment(VerticalAlignment.TOP)
        );

        IdTable.addCell(new Cell().add(new Paragraph(""))
                .setBorderTop(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );
        IdTable.addCell(new Cell().add(new Paragraph(""))
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );
        IdTable.addCell(new Cell().add(new Paragraph(""))
                .setBorderTop(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
        );
        return IdTable;
    }

    private static Table AddHeader(float[] headerWidth, String PhoneNumber) throws MalformedURLException {
        Table header = new Table(headerWidth);

        header.addCell(new Cell().add(new Paragraph("RtS"))
                .setFontColor(new DeviceRgb(3, 215, 252))
                .setFontSize(30)
                .setTextAlignment(TextAlignment.LEFT)
                .setPaddingLeft(20)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setBorderRight(Border.NO_BORDER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setBorderBottom(Border.NO_BORDER)
        );

        header.addCell(new Cell().add(new Image(ImageDataFactory.create("P:\\Java\\pdf\\src\\main\\java\\phoneIcon.png")).scaleAbsolute(20f,20f))
                .setTextAlignment(TextAlignment.RIGHT)
                .setBorderBottom(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setPaddingLeft(180)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)


        );

        Paragraph paragraph = new Paragraph();
        paragraph.add(new Text(PhoneNumber).setBold().setCharacterSpacing(0.7F));
        paragraph.add(new Text("\n24x7 Bus Service")
                .setFontSize(8)
                .setFontColor(new DeviceRgb(107, 107, 107))
        );
        header.addCell(new Cell().add(paragraph)
                .setTextAlignment(TextAlignment.LEFT)
                .setFontSize(9)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setPaddingRight(5)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
        );
        return header;

    }

    private static Table AddHeadder(String Heading, boolean WantMarginInTheBeginning) throws MalformedURLException {
        float[] Width = {50, 490};
        Table table = new Table(Width);

        if (WantMarginInTheBeginning){
            AddTableMargin(table, 6, new DeviceRgb(255,255,255));
        }
        table.addCell(new Cell().add(new Image(ImageDataFactory.create("P:\\Java\\pdf\\src\\main\\java\\Circle-icon.png")).scaleAbsolute(15,15))
                .setTextAlignment(TextAlignment.RIGHT)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setPaddingLeft(30)
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setPaddingTop(10)
                .setPaddingBottom(10)
        );

        table.addCell(new Cell().add(new Paragraph(Heading))
                .setFontColor(new DeviceRgb(107, 107, 107))
                .setBold()
                .setBackgroundColor(COLOR_FOR_TABLE_BACKGROUND)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER)
                .setBorderBottom(Border.NO_BORDER)
                .setMarginLeft(8)
                .setFontSize(10F)
                .setWordSpacing(2)
                .setCharacterSpacing(1.5F)
                .setPaddingTop(10)
                .setPaddingBottom(10)
        );
        AddTableMargin(table, 3, new DeviceRgb(255,255,255));

        return table;
    }
}
