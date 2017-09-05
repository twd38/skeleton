package controllers;

import api.ReceiptResponse;
import api.TagResponse;
import dao.TagDao;
import generated.tables.records.ReceiptsRecord;
import generated.tables.records.TagsRecord;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Path("/tags")
public class TagController {
    final TagDao tags;

    public TagController(TagDao tags) {
        this.tags = tags;
    }

    @PUT
    @Path("/{tag}")
//    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public void toggleTag(@PathParam("tag") String tag, String receiptId) {
        this.tags.toggle(tag, Integer.parseInt(receiptId));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TagResponse> getAllTags() {
        List<TagsRecord> receiptRecords = tags.getAllTags();
        return receiptRecords.stream().map(TagResponse::new).collect(toList());
    }

    @GET
    @Path("/{tag}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReceiptResponse> getTaggedReciepts(@PathParam("tag") String tag) {
        List<ReceiptsRecord> receiptsRecords = this.tags.getTaggedReciepts(tag);
        return receiptsRecords.stream().map(ReceiptResponse::new).collect(toList());
    }
}
